/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package controllers

import config.CFConfig
import connectors.deskpro.HmrcDeskproConnector
import connectors.deskpro.domain.TicketId
import org.jsoup.Jsoup
import org.mockito.Matchers.{eq => meq, _}
import org.mockito.Mockito._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.Application
import play.api.i18n.{Lang, Messages, MessagesApi}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.Json
import play.api.mvc.Request
import play.api.test.FakeRequest
import play.api.test.Helpers._
import uk.gov.hmrc.auth.core.authorise.Predicate
import uk.gov.hmrc.auth.core.retrieve.Retrieval
import uk.gov.hmrc.auth.core.{AuthConnector, Enrolments}
import uk.gov.hmrc.http.{HeaderCarrier, SessionKeys}
import uk.gov.hmrc.play.bootstrap.tools.Stubs

import scala.concurrent.{ExecutionContext, Future}

class PlayFrontendProblemReportsControllerSpec extends AnyWordSpec with GuiceOneAppPerTest with Matchers {

  override def fakeApplication(): Application =
    new GuiceApplicationBuilder()
      .configure(
        "metrics.jvm"                          -> false,
        "metrics.enabled"                      -> false,
        "enablePlayFrontendProblemReportsForm" -> true
      )
      .build()

  implicit val messages: Messages =
    fakeApplication().injector.instanceOf[MessagesApi].preferred(Seq(Lang("en")))

  "Requesting the standalone non-JavaScript page" should {
    "return 200 and valid HTML" in new TestScope(fakeApplication()) {
      val result = controller.reportFormNonJavaScript(Some("my-test-service"))(FakeRequest())

      status(result) should be(200)

      val document = Jsoup.parse(contentAsString(result))
      document.getElementById("error-feedback-form")            should not be null
      document.getElementsByClass("govuk-error-summary").size() should be(0)
    }
  }

  "Reporting a problem" should {

    "return 200 and a valid html page for a valid request with " +
      "JavaScript disabled for an unauthenticated user" in new TestScope(fakeApplication()) {

        hrmcConnectorWillReturnTheTicketId

        val request = generateRequest(javascriptEnabled = false)
        val result  = controller.submit()(request)

        status(result) should be(200)

        val document = Jsoup.parse(contentAsString(result))
        document.getElementsByClass("govuk-error-summary").size() should be(0)
        document.getElementsByClass("govuk-body").text()          should be(
          "Someone will get back to you within 2 working days."
        )
      }

    "return 200 and a valid html page for a valid request with " +
      "JavaScript disabled for an authenticated user" in new TestScope(fakeApplication()) {
        when(
          hmrcDeskproConnector.createDeskProTicket(
            meq("John Densmore"),
            meq("name@mail.com"),
            meq("Support Request"),
            meq(controller.problemMessage("Some Action", "Some Error")),
            meq("/contact/problem_reports"),
            meq(false),
            any[Request[AnyRef]](),
            meq(enrolments),
            meq(None),
            meq(None),
            meq(None)
          )(any(classOf[HeaderCarrier]))
        ).thenReturn(Future.successful(TicketId(123)))

        val request = generateRequest(
          javascriptEnabled = false
        ).withSession(
          SessionKeys.authToken -> "authToken"
        )
        val result  = controller.submit()(request)

        status(result) should be(200)

        val document = Jsoup.parse(contentAsString(result))
        document.getElementsByClass("govuk-error-summary").size() should be(0)
        document.getElementsByClass("govuk-body").text()          should be(
          "Someone will get back to you within 2 working days."
        )
      }

    "return 200 and a valid json for a valid request with " +
      "JavaScript enabled" in new TestScope(fakeApplication()) {
        when(
          hmrcDeskproConnector.createDeskProTicket(
            meq("John Densmore"),
            meq("name@mail.com"),
            meq("Support Request"),
            meq(controller.problemMessage("Some Action", "Some Error")),
            meq("/contact/problem_reports"),
            meq(true),
            any[Request[AnyRef]](),
            meq(None),
            meq(None),
            meq(None),
            meq(None)
          )(any(classOf[HeaderCarrier]))
        ).thenReturn(Future.successful(TicketId(123)))

        val request = generateRequest(javascriptEnabled = true)
        val result  = controller.submit()(request)

        status(result) should be(200)

        val message = contentAsJson(result).\("message").as[String]
        contentAsJson(result).\("status").as[String] shouldBe "OK"
        message                                        should include(
          "<h2 id=\"feedback-thank-you-header\">Thank you</h2>"
        )
        message                                        should include(
          "Someone will get back to you within 2 working days."
        )
      }

    "return 200 and a valid html page with validation error for invalid input with " +
      "JavaScript disabled" in new TestScope(fakeApplication()) {
        val result =
          controller.submit()(generateInvalidRequest(javascriptEnabled = false))

        status(result) should be(200)
        verifyZeroInteractions(hmrcDeskproConnector)

        val document = Jsoup.parse(contentAsString(result))
        document.getElementsByClass("govuk-error-summary").size() should be > 0
      }

    "return 400 and a valid json containing validation errors for invalid input with " +
      "JavaScript enabled" in new TestScope(fakeApplication()) {

        val result = controller.submit()(generateInvalidRequest())

        status(result)                                 should be(400)
        verifyZeroInteractions(hmrcDeskproConnector)

        contentAsJson(result).\("status").as[String] shouldBe "ERROR"
      }

    "fail if the email has invalid syntax (for DeskPRO)" in new TestScope(fakeApplication()) {
      val request = generateRequest(javascriptEnabled = false, email = "a@a")
      val submit  = controller.submit()(request)
      val page    = Jsoup.parse(contentAsString(submit))

      status(submit) shouldBe 200
      verifyZeroInteractions(hmrcDeskproConnector)

      page.getElementsByClass("govuk-error-summary").size() should be > 0
    }

    "fail if the name has invalid characters with " +
      "Javascript disabled" in new TestScope(fakeApplication()) {
        val request = generateRequest(
          javascriptEnabled = false,
          name = """<a href="blah.com">something</a>"""
        ).withSession(
          SessionKeys.authToken -> "authToken"
        )
        val submit  = controller.submit()(request)
        val page    = Jsoup.parse(contentAsString(submit))

        status(submit) shouldBe 200
        verifyZeroInteractions(hmrcDeskproConnector)

        page.getElementsByClass("govuk-error-summary").size() should be > 0
      }

    "return error page if the Deskpro ticket creation fails with " +
      "Javascript disabled" in new TestScope(fakeApplication()) {
        when(
          hmrcDeskproConnector.createDeskProTicket(
            meq("John Densmore"),
            meq("name@mail.com"),
            meq("Support Request"),
            meq(controller.problemMessage("Some Action", "Some Error")),
            meq("/contact/problem_reports"),
            meq(false),
            any[Request[AnyRef]](),
            meq(None),
            meq(None),
            meq(None),
            meq(None)
          )(any(classOf[HeaderCarrier]))
        ).thenReturn(Future.failed(new Exception("failed")))

        val request = generateRequest(javascriptEnabled = false)
        val result  = controller.submit()(request)
        status(result) should be(200)

        val document = Jsoup.parse(contentAsString(result))
        document.text() should include("Please try again later.")
      }

  }

  class TestScope(app: Application) extends MockitoSugar {

    val authConnector = new AuthConnector {
      override def authorise[A](predicate: Predicate, retrieval: Retrieval[A])(implicit
        hc: HeaderCarrier,
        ec: ExecutionContext
      ): Future[A] =
        Future.successful(
          Json.parse("{ \"allEnrolments\" : []}").as[A](retrieval.reads)
        )
    }

    val problemReportPage             =
      app.injector.instanceOf[views.html.problem_reports_nonjavascript]
    val problemReportErrorPage        =
      app.injector.instanceOf[views.html.problem_reports_error_nonjavascript]
    val problemReportConfirmationPage = app.injector
      .instanceOf[views.html.problem_reports_confirmation_nonjavascript]
    val playFrontendProblemReportPage =
      app.injector.instanceOf[views.html.ProblemReportsNonjsPage]
    val playFrontendConfirmationPage  =
      app.injector.instanceOf[views.html.ProblemReportsNonjsConfirmationPage]
    val errorFeedbackForm             =
      app.injector.instanceOf[views.html.partials.error_feedback]
    val playFrontendErrorFeedbackPage =
      app.injector.instanceOf[views.html.ProblemReportsNonjsErrorPage]
    val errorFeedbackFormInner        =
      app.injector.instanceOf[views.html.partials.error_feedback_inner]
    val ticketCreatedBody             =
      app.injector.instanceOf[views.html.ticket_created_body]

    val controller = new ProblemReportsController(
      mock[HmrcDeskproConnector],
      authConnector,
      Stubs.stubMessagesControllerComponents(
        messagesApi = app.injector.instanceOf[MessagesApi]
      ),
      problemReportPage,
      playFrontendProblemReportPage,
      problemReportErrorPage,
      playFrontendErrorFeedbackPage,
      problemReportConfirmationPage,
      playFrontendConfirmationPage,
      errorFeedbackForm,
      errorFeedbackFormInner,
      ticketCreatedBody
    )(new CFConfig(app.configuration), ExecutionContext.Implicits.global)

    val deskproName: String           = "John Densmore"
    val deskproEmail: String          = "name@mail.com"
    val deskproSubject: String        = "Support Request"
    val deskproProblemMessage: String =
      controller.problemMessage("Some Action", "Some Error")(
        app.injector.instanceOf[MessagesApi].preferred(Seq(Lang("en")))
      )
    val deskproReferrer: String       = "/contact/problem_reports"

    val hmrcDeskproConnector = controller.hmrcDeskproConnector

    val enrolments = Some(Enrolments(Set()))

    def generateRequest(
      javascriptEnabled: Boolean,
      name: String = deskproName,
      email: String = deskproEmail
    ) = {

      val headers = Seq(
        (REFERER, deskproReferrer),
        ("User-Agent", "iAmAUserAgent")
      ) ++ Seq(
        ("X-Requested-With", "XMLHttpRequest")
      ).filter(_ => javascriptEnabled)

      FakeRequest()
        .withHeaders(headers: _*)
        .withFormUrlEncodedBody(
          "report-name"   -> name,
          "report-email"  -> email,
          "report-action" -> "Some Action",
          "report-error"  -> "Some Error",
          "isJavascript"  -> javascriptEnabled.toString
        )
    }

    def generateInvalidRequest(javascriptEnabled: Boolean = true) = {

      val headers = Seq(
        (REFERER, deskproReferrer),
        ("User-Agent", "iAmAUserAgent")
      ) ++ Seq(
        ("X-Requested-With", "XMLHttpRequest")
      ).filter(_ => javascriptEnabled)

      FakeRequest()
        .withHeaders(headers: _*)
        .withFormUrlEncodedBody("isJavascript" -> javascriptEnabled.toString)
    }

    def hmrcConnectorWillFail =
      mockHmrcConnector(Future.failed(new Exception("failed")))

    def hrmcConnectorWillReturnTheTicketId =
      mockHmrcConnector(Future.successful(TicketId(123)))

    private def mockHmrcConnector(result: Future[TicketId]) =
      when(
        hmrcDeskproConnector.createDeskProTicket(
          meq(deskproName),
          meq(deskproEmail),
          meq(deskproSubject),
          meq(deskproProblemMessage),
          meq(deskproReferrer),
          meq(false),
          any[Request[AnyRef]](),
          meq(None),
          meq(None),
          meq(None),
          meq(None)
        )(any(classOf[HeaderCarrier]))
      ).thenReturn(result)
  }

}