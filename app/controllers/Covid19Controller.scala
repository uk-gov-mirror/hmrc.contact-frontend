package controllers

import config.AppConfig
import connectors.deskpro.HmrcDeskproConnector
import javax.inject.Inject
import model.Covid19Form
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, Lang}
import play.api.mvc.{Action, AnyContent, Call, MessagesControllerComponents, Request, Result}
import play.filters.csrf.CSRF
import services.DeskproSubmission
import uk.gov.hmrc.auth.core.AuthProvider.GovernmentGateway
import uk.gov.hmrc.auth.core.{AuthConnector, AuthProviders, AuthorisedFunctions}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import util.DeskproEmailValidator

import scala.concurrent.{ExecutionContext, Future}


object Covid19FormBind {

  private val emailValidator                     = new DeskproEmailValidator()
  private val validateEmail: (String) => Boolean = emailValidator.validate

  val form = Form[Covid19Form](
    mapping(
      "name" -> text
        .verifying("error.common.problem_report.name_mandatory", name => !name.trim.isEmpty)
        .verifying("error.common.problem_report.name_too_long", name => name.length <= 70),
      "email" -> text
        .verifying("error.email", validateEmail)
        .verifying("deskpro.email_too_long", email => email.size <= 255),
      "doing" -> text
        .verifying("error.common.covid.doing.required", comment => !comment.trim.isEmpty)
        .verifying("error.common.covid.toolong", comment => comment.length <= 1000),
      "problem" -> text
        .verifying("error.common.covid.problem.required", comment => !comment.trim.isEmpty)
        .verifying("error.common.covid.toolong", comment => comment.length <= 1000),
      "isJavascript" -> boolean,
      "referer"      -> optional(text),
      "csrfToken"    -> text,
      "service"      -> optional(text),
      "userAction"   -> optional(text)
    )(Covid19Form.apply)(Covid19Form.unapply)
  )

  def emptyForm(referer: Option[String],
            csrfToken: String,
            service: Option[String],
            userAction: Option[String]): Form[Covid19Form] =
    Covid19FormBind.form.fill(Covid19Form(name = "",
      email = "",
      doing =  "",
      problem = "",
      isJavascript = false,
      referer = referer,
      csrfToken = csrfToken,
      service = service,
      userAction = userAction))
}

class Covid19Controller @Inject()(val hmrcDeskproConnector: HmrcDeskproConnector,
                                  val authConnector: AuthConnector,
                                  val configuration: Configuration,
                                  mcc: MessagesControllerComponents)
                                 (implicit val appConfig: AppConfig,
                                  val executionContext: ExecutionContext)
  extends FrontendController(mcc)
    with DeskproSubmission
    with I18nSupport
    with AuthorisedFunctions
    with LoginRedirection
    with ContactFrontendActions {

  implicit def lang(implicit request: Request[_]): Lang = request.lang

  def covid19Form(service: Option[String], userAction: Option[String]): Action[AnyContent] = Action.async { implicit request =>
    loginRedirection(routes.Covid19Controller.covid19Form(service,userAction).url)(authorised(AuthProviders(GovernmentGateway))({
        index(service, userAction, routes.Covid19Controller.submitCovid19Form().url)
    }))
  }

  def covid19FormUnauthenticated(service: Option[String], userAction: Option[String]): Action[AnyContent] = Action.async { implicit request =>
      index(service, userAction, routes.Covid19Controller.submitCovid19FormUnauthenticated().url)
  }


  def submitCovid19Form(): Action[AnyContent] = Action.async { implicit request =>
    loginRedirection(routes.Covid19Controller.submitCovid19Form().url)(authorised(AuthProviders(GovernmentGateway))({
      submit(routes.Covid19Controller.submitCovid19FormUnauthenticated(), routes.Covid19Controller.confirmation())
    }))
  }

  def submitCovid19FormUnauthenticated(): Action[AnyContent] = Action.async { implicit request =>
    submit(routes.Covid19Controller.submitCovid19FormUnauthenticated(), routes.Covid19Controller.confirmationUnauthenticated())
  }

  def confirmation(): Action[AnyContent] = Action.async { implicit request =>
    loginRedirection(routes.Covid19Controller.confirmation().url)(authorised(AuthProviders(GovernmentGateway))({
      Future.successful(Ok(views.html.covid_confirmation()))
    }))
  }

  def confirmationUnauthenticated(): Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(views.html.covid_confirmation()))
  }

  private def index(service: Option[String], userAction: Option[String], submitUrl: String)(implicit request: Request[AnyContent]): Future[Result] =
    Future.successful {
      val referer = request.headers.get("Referer")
      val csrfToken = CSRF.getToken(request).map(_.value).getOrElse("")
      val form: Form[Covid19Form] = Covid19FormBind.emptyForm(referer = referer, csrfToken = csrfToken, service = service, userAction = userAction)
      Ok(views.html.covid(form, submitUrl))
    }

  private def submit(errorCall: Call, confirmationUrl:Call)(implicit request: Request[AnyContent]): Future[Result] = {
    Covid19FormBind
      .form
      .bindFromRequest()(request)
      .fold(
        (error : Form[Covid19Form]) =>
          Future.successful(BadRequest(views.html.covid(error, errorCall.url))),
        formData => for {
          _ <- createCovid19Ticket(formData, None)
        } yield Redirect(confirmationUrl))
  }
}
