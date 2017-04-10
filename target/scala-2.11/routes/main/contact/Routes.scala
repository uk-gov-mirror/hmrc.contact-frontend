
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/contact.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

package contact

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    contact.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback""", """controllers.FeedbackController.feedbackForm(service:Option[String])"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback-unauthenticated""", """controllers.FeedbackController.unauthenticatedFeedbackForm(service:Option[String])"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/submit""", """controllers.FeedbackController.submit"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/submit-unauthenticated""", """controllers.FeedbackController.submitUnauthenticated"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/thanks""", """controllers.FeedbackController.thanks"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/thanks-unauthenticated""", """controllers.FeedbackController.unauthenticatedThanks"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc""", """controllers.ContactHmrcController.index"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc""", """controllers.ContactHmrcController.submit"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc/thanks""", """controllers.ContactHmrcController.thanks"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem_reports""", """controllers.ProblemReportsController.reportForm(secure:Option[Boolean], csrfToken:Option[String], service:Option[String])"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem_reports_ajax""", """controllers.ProblemReportsController.reportFormAjax(service:Option[String])"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem_reports_nonjs""", """controllers.ProblemReportsController.reportFormNonJavaScript(service:Option[String])"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem_reports""", """controllers.ProblemReportsController.submit"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem_reports_secure""", """controllers.ProblemReportsController.submitSecure"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc/form""", """controllers.PartialsController.contactHmrcForm(submitUrl:String, csrfToken:String, service:Option[String], renderFormOnly:Option[Boolean])"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc/form""", """controllers.PartialsController.submitContactHmrcForm(resubmitUrl:String, renderFormOnly:Option[Boolean])"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact-hmrc/form/confirmation""", """controllers.PartialsController.contactHmrcFormConfirmation(ticketId:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/form""", """controllers.PartialsController.feedbackForm(submitUrl:String, csrfToken:String, service:Option[String], referer:Option[String])"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/form""", """controllers.PartialsController.submitFeedbackForm(resubmitUrl:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """beta-feedback/form/confirmation""", """controllers.PartialsController.feedbackFormConfirmation(ticketId:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """survey""", """controllers.SurveyController.survey(ticketId:String, serviceId:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """submitSurvey""", """controllers.SurveyController.submit()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """survey/confirmation""", """controllers.SurveyController.confirmation()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """switch-to-welsh""", """@controllers.LanguageController@.switchToWelsh()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """switch-to-english""", """@controllers.LanguageController@.switchToEnglish()"""),
    ("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """""" + "$" + """path<.+>""", """controllers.ApplicationController.options(path:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_FeedbackController_feedbackForm0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback")))
  )
  private[this] lazy val controllers_FeedbackController_feedbackForm0_invoker = createInvoker(
    controllers.FeedbackController.feedbackForm(fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "feedbackForm",
      Seq(classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """beta-feedback"""
    )
  )

  // @LINE:2
  private[this] lazy val controllers_FeedbackController_unauthenticatedFeedbackForm1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback-unauthenticated")))
  )
  private[this] lazy val controllers_FeedbackController_unauthenticatedFeedbackForm1_invoker = createInvoker(
    controllers.FeedbackController.unauthenticatedFeedbackForm(fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "unauthenticatedFeedbackForm",
      Seq(classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """beta-feedback-unauthenticated"""
    )
  )

  // @LINE:3
  private[this] lazy val controllers_FeedbackController_submit2_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/submit")))
  )
  private[this] lazy val controllers_FeedbackController_submit2_invoker = createInvoker(
    controllers.FeedbackController.submit,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """beta-feedback/submit"""
    )
  )

  // @LINE:4
  private[this] lazy val controllers_FeedbackController_submitUnauthenticated3_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/submit-unauthenticated")))
  )
  private[this] lazy val controllers_FeedbackController_submitUnauthenticated3_invoker = createInvoker(
    controllers.FeedbackController.submitUnauthenticated,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "submitUnauthenticated",
      Nil,
      "POST",
      """""",
      this.prefix + """beta-feedback/submit-unauthenticated"""
    )
  )

  // @LINE:5
  private[this] lazy val controllers_FeedbackController_thanks4_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/thanks")))
  )
  private[this] lazy val controllers_FeedbackController_thanks4_invoker = createInvoker(
    controllers.FeedbackController.thanks,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "thanks",
      Nil,
      "GET",
      """""",
      this.prefix + """beta-feedback/thanks"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_FeedbackController_unauthenticatedThanks5_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/thanks-unauthenticated")))
  )
  private[this] lazy val controllers_FeedbackController_unauthenticatedThanks5_invoker = createInvoker(
    controllers.FeedbackController.unauthenticatedThanks,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.FeedbackController",
      "unauthenticatedThanks",
      Nil,
      "GET",
      """""",
      this.prefix + """beta-feedback/thanks-unauthenticated"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ContactHmrcController_index6_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc")))
  )
  private[this] lazy val controllers_ContactHmrcController_index6_invoker = createInvoker(
    controllers.ContactHmrcController.index,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ContactHmrcController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """contact-hmrc"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ContactHmrcController_submit7_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc")))
  )
  private[this] lazy val controllers_ContactHmrcController_submit7_invoker = createInvoker(
    controllers.ContactHmrcController.submit,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ContactHmrcController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """contact-hmrc"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ContactHmrcController_thanks8_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc/thanks")))
  )
  private[this] lazy val controllers_ContactHmrcController_thanks8_invoker = createInvoker(
    controllers.ContactHmrcController.thanks,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ContactHmrcController",
      "thanks",
      Nil,
      "GET",
      """""",
      this.prefix + """contact-hmrc/thanks"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_ProblemReportsController_reportForm9_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("problem_reports")))
  )
  private[this] lazy val controllers_ProblemReportsController_reportForm9_invoker = createInvoker(
    controllers.ProblemReportsController.reportForm(fakeValue[Option[Boolean]], fakeValue[Option[String]], fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ProblemReportsController",
      "reportForm",
      Seq(classOf[Option[Boolean]], classOf[Option[String]], classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """problem_reports"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ProblemReportsController_reportFormAjax10_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("problem_reports_ajax")))
  )
  private[this] lazy val controllers_ProblemReportsController_reportFormAjax10_invoker = createInvoker(
    controllers.ProblemReportsController.reportFormAjax(fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ProblemReportsController",
      "reportFormAjax",
      Seq(classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """problem_reports_ajax"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ProblemReportsController_reportFormNonJavaScript11_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("problem_reports_nonjs")))
  )
  private[this] lazy val controllers_ProblemReportsController_reportFormNonJavaScript11_invoker = createInvoker(
    controllers.ProblemReportsController.reportFormNonJavaScript(fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ProblemReportsController",
      "reportFormNonJavaScript",
      Seq(classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """problem_reports_nonjs"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ProblemReportsController_submit12_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("problem_reports")))
  )
  private[this] lazy val controllers_ProblemReportsController_submit12_invoker = createInvoker(
    controllers.ProblemReportsController.submit,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ProblemReportsController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """problem_reports"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProblemReportsController_submitSecure13_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("problem_reports_secure")))
  )
  private[this] lazy val controllers_ProblemReportsController_submitSecure13_invoker = createInvoker(
    controllers.ProblemReportsController.submitSecure,
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ProblemReportsController",
      "submitSecure",
      Nil,
      "POST",
      """""",
      this.prefix + """problem_reports_secure"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_PartialsController_contactHmrcForm14_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc/form")))
  )
  private[this] lazy val controllers_PartialsController_contactHmrcForm14_invoker = createInvoker(
    controllers.PartialsController.contactHmrcForm(fakeValue[String], fakeValue[String], fakeValue[Option[String]], fakeValue[Option[Boolean]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "contactHmrcForm",
      Seq(classOf[String], classOf[String], classOf[Option[String]], classOf[Option[Boolean]]),
      "GET",
      """""",
      this.prefix + """contact-hmrc/form"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_PartialsController_submitContactHmrcForm15_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc/form")))
  )
  private[this] lazy val controllers_PartialsController_submitContactHmrcForm15_invoker = createInvoker(
    controllers.PartialsController.submitContactHmrcForm(fakeValue[String], fakeValue[Option[Boolean]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "submitContactHmrcForm",
      Seq(classOf[String], classOf[Option[Boolean]]),
      "POST",
      """""",
      this.prefix + """contact-hmrc/form"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_PartialsController_contactHmrcFormConfirmation16_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contact-hmrc/form/confirmation")))
  )
  private[this] lazy val controllers_PartialsController_contactHmrcFormConfirmation16_invoker = createInvoker(
    controllers.PartialsController.contactHmrcFormConfirmation(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "contactHmrcFormConfirmation",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """contact-hmrc/form/confirmation"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_PartialsController_feedbackForm17_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/form")))
  )
  private[this] lazy val controllers_PartialsController_feedbackForm17_invoker = createInvoker(
    controllers.PartialsController.feedbackForm(fakeValue[String], fakeValue[String], fakeValue[Option[String]], fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "feedbackForm",
      Seq(classOf[String], classOf[String], classOf[Option[String]], classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """beta-feedback/form"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_PartialsController_submitFeedbackForm18_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/form")))
  )
  private[this] lazy val controllers_PartialsController_submitFeedbackForm18_invoker = createInvoker(
    controllers.PartialsController.submitFeedbackForm(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "submitFeedbackForm",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """beta-feedback/form"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_PartialsController_feedbackFormConfirmation19_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("beta-feedback/form/confirmation")))
  )
  private[this] lazy val controllers_PartialsController_feedbackFormConfirmation19_invoker = createInvoker(
    controllers.PartialsController.feedbackFormConfirmation(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.PartialsController",
      "feedbackFormConfirmation",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """beta-feedback/form/confirmation"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_SurveyController_survey20_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("survey")))
  )
  private[this] lazy val controllers_SurveyController_survey20_invoker = createInvoker(
    controllers.SurveyController.survey(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.SurveyController",
      "survey",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """survey"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_SurveyController_submit21_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitSurvey")))
  )
  private[this] lazy val controllers_SurveyController_submit21_invoker = createInvoker(
    controllers.SurveyController.submit(),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.SurveyController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """submitSurvey"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_SurveyController_confirmation22_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("survey/confirmation")))
  )
  private[this] lazy val controllers_SurveyController_confirmation22_invoker = createInvoker(
    controllers.SurveyController.confirmation(),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.SurveyController",
      "confirmation",
      Nil,
      "GET",
      """""",
      this.prefix + """survey/confirmation"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_LanguageController_switchToWelsh23_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("switch-to-welsh")))
  )
  private[this] lazy val controllers_LanguageController_switchToWelsh23_invoker = createInvoker(
    play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.LanguageController]).switchToWelsh(),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.LanguageController",
      "switchToWelsh",
      Nil,
      "GET",
      """""",
      this.prefix + """switch-to-welsh"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_LanguageController_switchToEnglish24_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("switch-to-english")))
  )
  private[this] lazy val controllers_LanguageController_switchToEnglish24_invoker = createInvoker(
    play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.LanguageController]).switchToEnglish(),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.LanguageController",
      "switchToEnglish",
      Nil,
      "GET",
      """""",
      this.prefix + """switch-to-english"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ApplicationController_options25_route: Route.ParamsExtractor = Route("OPTIONS",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("path", """.+""",false)))
  )
  private[this] lazy val controllers_ApplicationController_options25_invoker = createInvoker(
    controllers.ApplicationController.options(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "contact",
      "controllers.ApplicationController",
      "options",
      Seq(classOf[String]),
      "OPTIONS",
      """""",
      this.prefix + """""" + "$" + """path<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_FeedbackController_feedbackForm0_route(params) =>
      call(params.fromQuery[Option[String]]("service", None)) { (service) =>
        controllers_FeedbackController_feedbackForm0_invoker.call(controllers.FeedbackController.feedbackForm(service))
      }
  
    // @LINE:2
    case controllers_FeedbackController_unauthenticatedFeedbackForm1_route(params) =>
      call(params.fromQuery[Option[String]]("service", None)) { (service) =>
        controllers_FeedbackController_unauthenticatedFeedbackForm1_invoker.call(controllers.FeedbackController.unauthenticatedFeedbackForm(service))
      }
  
    // @LINE:3
    case controllers_FeedbackController_submit2_route(params) =>
      call { 
        controllers_FeedbackController_submit2_invoker.call(controllers.FeedbackController.submit)
      }
  
    // @LINE:4
    case controllers_FeedbackController_submitUnauthenticated3_route(params) =>
      call { 
        controllers_FeedbackController_submitUnauthenticated3_invoker.call(controllers.FeedbackController.submitUnauthenticated)
      }
  
    // @LINE:5
    case controllers_FeedbackController_thanks4_route(params) =>
      call { 
        controllers_FeedbackController_thanks4_invoker.call(controllers.FeedbackController.thanks)
      }
  
    // @LINE:6
    case controllers_FeedbackController_unauthenticatedThanks5_route(params) =>
      call { 
        controllers_FeedbackController_unauthenticatedThanks5_invoker.call(controllers.FeedbackController.unauthenticatedThanks)
      }
  
    // @LINE:9
    case controllers_ContactHmrcController_index6_route(params) =>
      call { 
        controllers_ContactHmrcController_index6_invoker.call(controllers.ContactHmrcController.index)
      }
  
    // @LINE:10
    case controllers_ContactHmrcController_submit7_route(params) =>
      call { 
        controllers_ContactHmrcController_submit7_invoker.call(controllers.ContactHmrcController.submit)
      }
  
    // @LINE:11
    case controllers_ContactHmrcController_thanks8_route(params) =>
      call { 
        controllers_ContactHmrcController_thanks8_invoker.call(controllers.ContactHmrcController.thanks)
      }
  
    // @LINE:13
    case controllers_ProblemReportsController_reportForm9_route(params) =>
      call(params.fromQuery[Option[Boolean]]("secure", None), params.fromQuery[Option[String]]("csrfToken", None), params.fromQuery[Option[String]]("service", None)) { (secure, csrfToken, service) =>
        controllers_ProblemReportsController_reportForm9_invoker.call(controllers.ProblemReportsController.reportForm(secure, csrfToken, service))
      }
  
    // @LINE:14
    case controllers_ProblemReportsController_reportFormAjax10_route(params) =>
      call(params.fromQuery[Option[String]]("service", None)) { (service) =>
        controllers_ProblemReportsController_reportFormAjax10_invoker.call(controllers.ProblemReportsController.reportFormAjax(service))
      }
  
    // @LINE:15
    case controllers_ProblemReportsController_reportFormNonJavaScript11_route(params) =>
      call(params.fromQuery[Option[String]]("service", None)) { (service) =>
        controllers_ProblemReportsController_reportFormNonJavaScript11_invoker.call(controllers.ProblemReportsController.reportFormNonJavaScript(service))
      }
  
    // @LINE:16
    case controllers_ProblemReportsController_submit12_route(params) =>
      call { 
        controllers_ProblemReportsController_submit12_invoker.call(controllers.ProblemReportsController.submit)
      }
  
    // @LINE:17
    case controllers_ProblemReportsController_submitSecure13_route(params) =>
      call { 
        controllers_ProblemReportsController_submitSecure13_invoker.call(controllers.ProblemReportsController.submitSecure)
      }
  
    // @LINE:19
    case controllers_PartialsController_contactHmrcForm14_route(params) =>
      call(params.fromQuery[String]("submitUrl", None), params.fromQuery[String]("csrfToken", None), params.fromQuery[Option[String]]("service", None), params.fromQuery[Option[Boolean]]("renderFormOnly", None)) { (submitUrl, csrfToken, service, renderFormOnly) =>
        controllers_PartialsController_contactHmrcForm14_invoker.call(controllers.PartialsController.contactHmrcForm(submitUrl, csrfToken, service, renderFormOnly))
      }
  
    // @LINE:20
    case controllers_PartialsController_submitContactHmrcForm15_route(params) =>
      call(params.fromQuery[String]("resubmitUrl", None), params.fromQuery[Option[Boolean]]("renderFormOnly", None)) { (resubmitUrl, renderFormOnly) =>
        controllers_PartialsController_submitContactHmrcForm15_invoker.call(controllers.PartialsController.submitContactHmrcForm(resubmitUrl, renderFormOnly))
      }
  
    // @LINE:21
    case controllers_PartialsController_contactHmrcFormConfirmation16_route(params) =>
      call(params.fromQuery[String]("ticketId", None)) { (ticketId) =>
        controllers_PartialsController_contactHmrcFormConfirmation16_invoker.call(controllers.PartialsController.contactHmrcFormConfirmation(ticketId))
      }
  
    // @LINE:22
    case controllers_PartialsController_feedbackForm17_route(params) =>
      call(params.fromQuery[String]("submitUrl", None), params.fromQuery[String]("csrfToken", None), params.fromQuery[Option[String]]("service", None), params.fromQuery[Option[String]]("referer", None)) { (submitUrl, csrfToken, service, referer) =>
        controllers_PartialsController_feedbackForm17_invoker.call(controllers.PartialsController.feedbackForm(submitUrl, csrfToken, service, referer))
      }
  
    // @LINE:23
    case controllers_PartialsController_submitFeedbackForm18_route(params) =>
      call(params.fromQuery[String]("resubmitUrl", None)) { (resubmitUrl) =>
        controllers_PartialsController_submitFeedbackForm18_invoker.call(controllers.PartialsController.submitFeedbackForm(resubmitUrl))
      }
  
    // @LINE:24
    case controllers_PartialsController_feedbackFormConfirmation19_route(params) =>
      call(params.fromQuery[String]("ticketId", None)) { (ticketId) =>
        controllers_PartialsController_feedbackFormConfirmation19_invoker.call(controllers.PartialsController.feedbackFormConfirmation(ticketId))
      }
  
    // @LINE:26
    case controllers_SurveyController_survey20_route(params) =>
      call(params.fromQuery[String]("ticketId", None), params.fromQuery[String]("serviceId", None)) { (ticketId, serviceId) =>
        controllers_SurveyController_survey20_invoker.call(controllers.SurveyController.survey(ticketId, serviceId))
      }
  
    // @LINE:27
    case controllers_SurveyController_submit21_route(params) =>
      call { 
        controllers_SurveyController_submit21_invoker.call(controllers.SurveyController.submit())
      }
  
    // @LINE:28
    case controllers_SurveyController_confirmation22_route(params) =>
      call { 
        controllers_SurveyController_confirmation22_invoker.call(controllers.SurveyController.confirmation())
      }
  
    // @LINE:30
    case controllers_LanguageController_switchToWelsh23_route(params) =>
      call { 
        controllers_LanguageController_switchToWelsh23_invoker.call(play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.LanguageController]).switchToWelsh())
      }
  
    // @LINE:31
    case controllers_LanguageController_switchToEnglish24_route(params) =>
      call { 
        controllers_LanguageController_switchToEnglish24_invoker.call(play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.LanguageController]).switchToEnglish())
      }
  
    // @LINE:33
    case controllers_ApplicationController_options25_route(params) =>
      call(params.fromPath[String]("path", None)) { (path) =>
        controllers_ApplicationController_options25_invoker.call(controllers.ApplicationController.options(path))
      }
  }
}
