package unit.controllers

import config.CFConfig
import connectors.deskpro.HmrcDeskproConnector
import connectors.deskpro.domain.TicketId
import controllers.Covid19Controller
import org.jsoup.Jsoup
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import play.api.i18n.{Lang, Messages, MessagesApi}
import play.api.{Application, Configuration}
import play.api.libs.json.Json
import play.api.mvc.Request
import play.api.test.FakeRequest
import play.api.test.Helpers._
import uk.gov.hmrc.auth.core.{AuthConnector, Enrolments}
import uk.gov.hmrc.auth.core.authorise.Predicate
import uk.gov.hmrc.auth.core.retrieve.Retrieval
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.bootstrap.tools.Stubs
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

import scala.concurrent.{ExecutionContext, Future}

class Covid19ControllerSpec  extends UnitSpec with WithFakeApplication {

  implicit val message: Messages = fakeApplication.injector.instanceOf[MessagesApi].preferred(Seq(Lang("en")))

  "Getting help via the Covid-19 form" should {
    "return a 200 and a valid html page for a request" in new Covid19ControllerApp(fakeApplication) {
      val request = FakeRequest()
      val useraction = "/test/123"
      val result = controller.covid19Form(service = None, userAction = Some(useraction))(request)

      status(result) should be (200)
      val document = Jsoup.parse(contentAsString(result))
      document.title() should be(Messages("covid.heading"))

      document.getElementById("covid-form") should not be null
      document.getElementById("service").`val`() should be("")
      document.getElementsByAttributeValue("name", "userAction").first().`val`() shouldBe useraction
    }

  }

  "Requesting help" should {
    "display error if form is totally empty" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "", problem = "", name = "", email = "", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(4)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.problem_report.action_mandatory.b"))) shouldBe true
      errors.exists(_.text().equals(Messages("problem_report.error"))) shouldBe true
      errors.exists(_.text().equals(Messages("error.common.problem_report.name_mandatory"))) shouldBe true
      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true


    }

    "display error if name is missing" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "bbb", name = "", email = "ccc@c.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.problem_report.name_mandatory"))) shouldBe true
    }


    "display error if name is too long" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "bbb", name = ("x" * 100), email = "ccc@c.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.problem_report.name_too_long"))) shouldBe true
    }

    "display error if email is missing" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "bbb", name = "ccc", email = "", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true
    }

    "display error if email is invalid"  in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "bbb", name = "ccc", email = "email", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true
    }

    "display error if email is too long"  in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "bbb", name = "ccc", email = ("x" * 500)+"@c.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(2)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.email"))) shouldBe true
      errors.exists(_.text().equals(Messages("deskpro.email_too_long"))) shouldBe true
    }

    "display error if doing description is missing" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "", problem = "bbb", name = "ccc", email = "email@address.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.problem_report.action_mandatory.b"))) shouldBe true
    }

    "display error if doing description is too long"  in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = ("x" * 2001), problem = "bbb", name = "ccc", email = "email@address.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.covid.toolong"))) shouldBe true
    }

    "display error if problem description is missing" in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa", problem = "", name = "ccc", email = "email@address.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("problem_report.error"))) shouldBe true
    }

    "display error if problem description is too long"  in new Covid19ControllerApp(fakeApplication){
      val request = generateRequest(doing = "aaa" , problem = ("x" * 2001), name = "ccc", email = "email@address.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)

      status(result) should be (400)

      import collection.JavaConverters._

      val document = Jsoup.parse(contentAsString(result))
      val errors = document.getElementsByClass("error-message").asScala
      errors.length should be(1)
      document.title() should be("Error: " + Messages("covid.heading"))
      errors.exists(_.text().equals(Messages("error.common.covid.toolong"))) shouldBe true
    }

    "redirect to confirmation page when a valid form is processed successfully" in new Covid19ControllerApp(fakeApplication) {
      import org.mockito.Matchers._

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

      val request = generateRequest(doing = "aaa" , problem = "bbb", name = "ccc", email = "email@address.com", isJavascript = false, referrer = "/somepage")
      val result = controller.submitCovid19Form()(request)
      status(result) should be(303)
      header(LOCATION, result) should be(Some("/contact/covid/confirmation"))
    }

  }


  class Covid19ControllerApp(app: Application) extends MockitoSugar {
    val hmrcDeskproConnector: HmrcDeskproConnector = mock[HmrcDeskproConnector]

    val authConnector: AuthConnector = new AuthConnector {
      override def authorise[A](predicate: Predicate, retrieval: Retrieval[A])(implicit hc: HeaderCarrier, ec: ExecutionContext): Future[A] = {
        Future.successful(Json.parse("{ \"allEnrolments\" : []}").as[A](retrieval.reads))
      }
    }
    implicit val cconfig: CFConfig = new CFConfig(app.configuration)

    val controller = new Covid19Controller(
      hmrcDeskproConnector,
      authConnector,
      Configuration(),
      Stubs.stubMessagesControllerComponents(messagesApi = app.injector.instanceOf[MessagesApi]))(cconfig, ExecutionContext.global)

    def generateRequest(doing: String, problem: String, name: String, email: String, isJavascript: Boolean, referrer: String) = {
      val fields = Map(
        "doing" -> doing,
        "problem" -> problem,
        "name" -> name,
        "email" -> email,
        "csrfToken" -> "token",
        "isJavascript" -> isJavascript.toString,
        "csrfToken" -> "a-csrf-token",
        "referer" -> referrer,
        "service" -> "unit-test",
        "userAction" -> "/test/url/action")

      FakeRequest()
        .withHeaders(("referer", referrer))
        .withFormUrlEncodedBody(fields.toSeq: _*)
    }
  }
}
