package unit.controllers

import config.CFConfig
import connectors.deskpro.HmrcDeskproConnector
import connectors.deskpro.domain.TicketId
import controllers.AccessibilityController
import org.jsoup.Jsoup
import org.mockito.Mockito._
import org.mockito.Matchers.{eq => meq, _}
import org.scalatest.mockito.MockitoSugar
import play.api.i18n.{Lang, Messages, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc.Request
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.{Application, Configuration, Environment}
import uk.gov.hmrc.auth.core.{AuthConnector, Enrolments}
import uk.gov.hmrc.auth.core.authorise.Predicate
import uk.gov.hmrc.auth.core.retrieve.Retrieval
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}
import util.BackUrlValidator

import scala.concurrent.{ExecutionContext, Future}

class zAccessibilityControllerSpec extends UnitSpec with WithFakeApplication {

  implicit val message: Messages = fakeApplication.injector.instanceOf[MessagesApi].preferred(Seq(Lang("en")))

  "Reporting an accessibility problem" should {

    "return 200 and a valid html page for a request" in new AccessibilityControllerApplication(fakeApplication) {

      val request = FakeRequest()
      val result = controller.accessibilityForm(service = None, userAction = Some("test?1234=xyz"))(request)

      status(result) should be (200)
      val document = Jsoup.parse(contentAsString(result))
      document.getElementById("accessibility-form") should not be null
      document.getElementById("service").`val`() should be ("")
      document.getElementsByAttributeValue("name", "userAction").first().`val`() shouldBe "test?1234=xyz"
    }

    "display errors when form isn't filled out at all" in new AccessibilityControllerApplication(fakeApplication) {

      val request = generateRequest(desc = "",formName = "",email = "", isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (400)

      import collection.JavaConverters._
      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-notification").asScala
      errors.length should be (3)

      errors.exists(_.text().equals(Messages("error.common.accessibility.problem.required"))) shouldBe true
      errors.exists(_.text().equals(Messages("error.common.feedback.name_mandatory"))) shouldBe true
      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true
    }

    "display error messages when message size exceeds limit" in new AccessibilityControllerApplication(fakeApplication) {
      val msg2500 = "x" * 2500

      val request = generateRequest(desc = msg2500, formName = "firstname",email = "firstname@email.gov", isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (400)

      import collection.JavaConverters._
      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-notification").asScala
      errors.length should be (1)

      errors.exists(_.text().equals(Messages("error.common.accessibility.problem.toolong"))) shouldBe true
    }

    "display error messages when email is invalid" in new AccessibilityControllerApplication(fakeApplication) {
      val badEmail = "firstname'email.gov."

      val request = generateRequest(desc = "valid form message", formName = "firstname",email = badEmail, isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (400)

      import collection.JavaConverters._
      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-notification").asScala
      errors.length should be (1)

      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true
    }

    "display error messages when email is too long" in new AccessibilityControllerApplication(fakeApplication) {
      val tooLongEmail = ("x" * 256) + "@email.com"

      val request = generateRequest(desc = "valid form message", formName = "firstname",email = tooLongEmail, isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (400)

      import collection.JavaConverters._
      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-notification").asScala
      errors.exists(_.text().equals(Messages("deskpro.email_too_long"))) shouldBe true
    }

    "display error messages when name is too long" in new AccessibilityControllerApplication(fakeApplication) {
      val longName = "x" * 256

      val request = generateRequest(desc = "valid form message", formName = longName, email = "valid@email.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (400)

      import collection.JavaConverters._
      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-notification").asScala
      errors.exists(_.text().equals(Messages("error.common.feedback.name_too_long"))) shouldBe true
    }


    "redirect to thankyou page when completed" in new AccessibilityControllerApplication(fakeApplication) {
      when(hmrcDeskproConnector.createDeskProTicket(
        name = any[String],
        email = any[String],
        subject = any[String],
        message = any[String],
        referrer = any[String],
        isJavascript = any[Boolean],
        any[Request[AnyRef]](),
        any[Option[Enrolments]],
        any[Option[String]],
        any[Option[String]],
        any[Option[String]])(any[HeaderCarrier])).thenReturn(Future.successful(TicketId(1234)))

      val request = generateRequest(desc = "valid form message", formName = "valid name", email = "valid@email.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitAccessibilityForm()(request)

      status(result) should be (303)
      header(LOCATION, result) should be (Some("/contact/accessibility/thanks"))
    }
  }

  class AccessibilityControllerApplication(app: Application) extends MockitoSugar {


    val hmrcDeskproConnector: HmrcDeskproConnector = mock[HmrcDeskproConnector]


    val authConnector: AuthConnector = new AuthConnector {
      override def authorise[A](predicate: Predicate, retrieval: Retrieval[A])(implicit hc: HeaderCarrier, ec: ExecutionContext): Future[A] = {
        Future.successful(Json.parse("{ \"allEnrolments\" : []}").as[A](retrieval.reads))
      }
    }

    val backUrlValidator: BackUrlValidator = new BackUrlValidator() {
      override def validate(backUrl: String) = backUrl == "http://www.valid.url"
    }


    val environment: Environment = Environment.simple()

    implicit val cconfig: CFConfig = new CFConfig(environment, app.configuration)
    val controller = new AccessibilityController(
      hmrcDeskproConnector,
      authConnector,
      backUrlValidator,
      Configuration(),
      environment)(cconfig, app.injector.instanceOf[MessagesApi])


    def generateRequest(desc: String, formName: String, email: String, isJavascript: Boolean, referrer: String) = {
      val fields = Map(
        "problemDescription" -> desc,
        "name"               -> formName,
        "email"              -> email,
        "csrfToken"          -> "token",
        "isJavascript"       -> isJavascript.toString,
        "csrfToken"          -> "a-csrf-token",
        "referer"            -> referrer,
        "service"            -> "unit-test",
        "userAction"         -> "/test/url/action")

      FakeRequest()
        .withHeaders(("referer", referrer))
        .withFormUrlEncodedBody(fields.toSeq: _*)
    }
  }


}
