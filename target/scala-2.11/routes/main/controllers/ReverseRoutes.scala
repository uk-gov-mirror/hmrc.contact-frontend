
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/contact.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:9
  class ReverseContactHmrcController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def thanks(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "contact-hmrc/thanks")
    }
  
    // @LINE:9
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "contact-hmrc")
    }
  
    // @LINE:10
    def submit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "contact-hmrc")
    }
  
  }

  // @LINE:33
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def options(path:String): Call = {
      import ReverseRouteContext.empty
      Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("path", path))
    }
  
  }

  // @LINE:19
  class ReversePartialsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def feedbackForm(submitUrl:String, csrfToken:String, service:Option[String], referer:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback/form" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("submitUrl", submitUrl)), Some(implicitly[QueryStringBindable[String]].unbind("csrfToken", csrfToken)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("referer", referer)))))
    }
  
    // @LINE:23
    def submitFeedbackForm(resubmitUrl:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "beta-feedback/form" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("resubmitUrl", resubmitUrl)))))
    }
  
    // @LINE:24
    def feedbackFormConfirmation(ticketId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback/form/confirmation" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ticketId", ticketId)))))
    }
  
    // @LINE:21
    def contactHmrcFormConfirmation(ticketId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "contact-hmrc/form/confirmation" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ticketId", ticketId)))))
    }
  
    // @LINE:19
    def contactHmrcForm(submitUrl:String, csrfToken:String, service:Option[String], renderFormOnly:Option[Boolean]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "contact-hmrc/form" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("submitUrl", submitUrl)), Some(implicitly[QueryStringBindable[String]].unbind("csrfToken", csrfToken)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)), Some(implicitly[QueryStringBindable[Option[Boolean]]].unbind("renderFormOnly", renderFormOnly)))))
    }
  
    // @LINE:20
    def submitContactHmrcForm(resubmitUrl:String, renderFormOnly:Option[Boolean]): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "contact-hmrc/form" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("resubmitUrl", resubmitUrl)), Some(implicitly[QueryStringBindable[Option[Boolean]]].unbind("renderFormOnly", renderFormOnly)))))
    }
  
  }

  // @LINE:1
  class ReverseFeedbackController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def unauthenticatedThanks(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback/thanks-unauthenticated")
    }
  
    // @LINE:3
    def submit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "beta-feedback/submit")
    }
  
    // @LINE:1
    def feedbackForm(service:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)))))
    }
  
    // @LINE:5
    def thanks(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback/thanks")
    }
  
    // @LINE:4
    def submitUnauthenticated(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "beta-feedback/submit-unauthenticated")
    }
  
    // @LINE:2
    def unauthenticatedFeedbackForm(service:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "beta-feedback-unauthenticated" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)))))
    }
  
  }

  // @LINE:13
  class ReverseProblemReportsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def submit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "problem_reports")
    }
  
    // @LINE:17
    def submitSecure(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "problem_reports_secure")
    }
  
    // @LINE:13
    def reportForm(secure:Option[Boolean], csrfToken:Option[String], service:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "problem_reports" + queryString(List(Some(implicitly[QueryStringBindable[Option[Boolean]]].unbind("secure", secure)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("csrfToken", csrfToken)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)))))
    }
  
    // @LINE:15
    def reportFormNonJavaScript(service:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "problem_reports_nonjs" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)))))
    }
  
    // @LINE:14
    def reportFormAjax(service:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "problem_reports_ajax" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("service", service)))))
    }
  
  }

  // @LINE:30
  class ReverseLanguageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def switchToEnglish(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "switch-to-english")
    }
  
    // @LINE:30
    def switchToWelsh(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "switch-to-welsh")
    }
  
  }

  // @LINE:26
  class ReverseSurveyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def survey(ticketId:String, serviceId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "survey" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ticketId", ticketId)), Some(implicitly[QueryStringBindable[String]].unbind("serviceId", serviceId)))))
    }
  
    // @LINE:28
    def confirmation(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "survey/confirmation")
    }
  
    // @LINE:27
    def submit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "submitSurvey")
    }
  
  }


}
