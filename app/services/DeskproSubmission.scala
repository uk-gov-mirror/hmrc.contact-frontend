package services

import connectors.deskpro.HmrcDeskproConnector
import connectors.deskpro.domain.TicketId
import controllers.ContactForm
import model.{AccessibilityForm, Covid19Form, FeedbackForm, ProblemReport}
import org.apache.http.client.utils.URIBuilder
import play.api.i18n.Messages
import play.api.mvc.{AnyContent, Request}
import uk.gov.hmrc.auth.core.Enrolments
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.HeaderCarrierConverter

import scala.concurrent.Future
import scala.util.Try

trait DeskproSubmission {

  import DeskproSubmission.replaceRefererPath

  private val Covid19Subject = "COVID-19 Support Request"
  private val Subject = "Contact form submission"

  protected def hmrcDeskproConnector: HmrcDeskproConnector

  def createDeskproTicket(data: ContactForm, enrolments: Option[Enrolments])(
    implicit request: Request[AnyContent],
    hc: HeaderCarrier): Future[TicketId] =
    hmrcDeskproConnector.createDeskProTicket(
      name             = data.contactName,
      email            = data.contactEmail,
      subject          = Subject,
      message          = data.contactComments,
      referrer         = replaceRefererPath(data.referer, data.userAction),
      isJavascript     = data.isJavascript,
      request          = request,
      enrolmentsOption = enrolments,
      service          = data.service,
      abFeatures       = data.abFeatures,
      userAction       = data.userAction
    )

  def createDeskproFeedback(data: FeedbackForm, enrolments: Option[Enrolments])(
    implicit request: Request[AnyContent],
    hc: HeaderCarrier): Future[TicketId] =
    hmrcDeskproConnector.createFeedback(
      name    = data.name,
      email   = data.email,
      rating  = data.experienceRating,
      subject = "Beta feedback submission",
      message = data.comments match {
        case ""      => "No comment given"
        case comment => comment
      },
      referrer         = data.referrer,
      isJavascript     = data.javascriptEnabled,
      request          = request,
      enrolmentsOption = enrolments,
      service          = data.service,
      abFeatures       = data.abFeatures
    )

  def createProblemReportsTicket(
    problemReport: ProblemReport,
    request: Request[AnyRef],
    enrolmentsOption: Option[Enrolments],
    referrer: Option[String])(implicit messages: Messages): Future[TicketId] = {
    implicit val hc = HeaderCarrierConverter.fromHeadersAndSession(request.headers, Some(request.session))
    hmrcDeskproConnector.createDeskProTicket(
      name             = problemReport.reportName,
      email            = problemReport.reportEmail,
      subject          = "Support Request",
      message          = problemMessage(problemReport.reportAction, problemReport.reportError),
      referrer         = replaceRefererPath(referrer.getOrElse(""), problemReport.userAction),
      isJavascript     = problemReport.isJavascript,
      request          = request,
      enrolmentsOption = enrolmentsOption,
      service          = problemReport.service,
      abFeatures       = problemReport.abFeatures,
      userAction       = problemReport.userAction
    )
  }

  def problemMessage(action: String, error: String)(implicit messages: Messages): String =
    s"""
    ${Messages("problem_report.action")}:
    $action

    ${Messages("problem_report.error")}:
    $error
    """

  def createAccessibilityTicket(accessibilityForm: AccessibilityForm, enrolments: Option[Enrolments])(implicit req: Request[AnyContent], hc: HeaderCarrier): Future[TicketId] = {

    hmrcDeskproConnector.createDeskProTicket(
      name             = accessibilityForm.name,
      email            = accessibilityForm.email,
      subject          = "Accessibility Problem",
      message          = accessibilityForm.problemDescription,
      referrer         = replaceRefererPath(accessibilityForm.referrer, accessibilityForm.userAction),
      isJavascript     = accessibilityForm.isJavascript,
      request          = req,
      enrolmentsOption = enrolments,
      service          = accessibilityForm.service,
      abFeatures       = None,
      userAction       = accessibilityForm.userAction
    )
  }

  def createCovid19Ticket(covid19Form: Covid19Form, enrolments: Option[Enrolments])(implicit request: Request[AnyContent], hc: HeaderCarrier, messages: Messages): Future[TicketId] = {
    hmrcDeskproConnector.createDeskProTicket(
      name             = covid19Form.name,
      email            = covid19Form.email,
      subject          = Covid19Subject,
      message          = problemMessage(covid19Form.doing, covid19Form.problem),
      referrer         = replaceRefererPath(covid19Form.referer.getOrElse(""), covid19Form.userAction),
      isJavascript     = covid19Form.isJavascript,
      request          = request,
      enrolmentsOption = enrolments,
      service          = covid19Form.service,
      abFeatures       = None,
      userAction       = covid19Form.userAction
    )
  }

}

object DeskproSubmission {

    def replaceRefererPath(referer: String, path: Option[String]): String =
      path
        .filter(_.trim.nonEmpty)
        .map(p => buildUri(referer).setPath(p).build().toASCIIString)
        .getOrElse(referer)

  private def buildUri(referer: String) : URIBuilder =
    Try(new URIBuilder(referer)).getOrElse(new URIBuilder())


}
