
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/contact.routes
// @DATE:Thu Mar 30 11:37:41 BST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:9
  class ReverseContactHmrcController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def thanks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContactHmrcController.thanks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc/thanks"})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContactHmrcController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc"})
        }
      """
    )
  
    // @LINE:10
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContactHmrcController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc"})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def options: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.options",
      """
        function(path0) {
          return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("path", path0)})
        }
      """
    )
  
  }

  // @LINE:19
  class ReversePartialsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def feedbackForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.feedbackForm",
      """
        function(submitUrl0,csrfToken1,service2,referer3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/form" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("submitUrl", submitUrl0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("csrfToken", csrfToken1), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service2), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("referer", referer3)])})
        }
      """
    )
  
    // @LINE:23
    def submitFeedbackForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.submitFeedbackForm",
      """
        function(resubmitUrl0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/form" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("resubmitUrl", resubmitUrl0)])})
        }
      """
    )
  
    // @LINE:24
    def feedbackFormConfirmation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.feedbackFormConfirmation",
      """
        function(ticketId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/form/confirmation" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ticketId", ticketId0)])})
        }
      """
    )
  
    // @LINE:21
    def contactHmrcFormConfirmation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.contactHmrcFormConfirmation",
      """
        function(ticketId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc/form/confirmation" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ticketId", ticketId0)])})
        }
      """
    )
  
    // @LINE:19
    def contactHmrcForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.contactHmrcForm",
      """
        function(submitUrl0,csrfToken1,service2,renderFormOnly3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc/form" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("submitUrl", submitUrl0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("csrfToken", csrfToken1), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service2), (""" + implicitly[QueryStringBindable[Option[Boolean]]].javascriptUnbind + """)("renderFormOnly", renderFormOnly3)])})
        }
      """
    )
  
    // @LINE:20
    def submitContactHmrcForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PartialsController.submitContactHmrcForm",
      """
        function(resubmitUrl0,renderFormOnly1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "contact-hmrc/form" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("resubmitUrl", resubmitUrl0), (""" + implicitly[QueryStringBindable[Option[Boolean]]].javascriptUnbind + """)("renderFormOnly", renderFormOnly1)])})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseFeedbackController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def unauthenticatedThanks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.unauthenticatedThanks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/thanks-unauthenticated"})
        }
      """
    )
  
    // @LINE:3
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/submit"})
        }
      """
    )
  
    // @LINE:1
    def feedbackForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.feedbackForm",
      """
        function(service0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service0)])})
        }
      """
    )
  
    // @LINE:5
    def thanks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.thanks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/thanks"})
        }
      """
    )
  
    // @LINE:4
    def submitUnauthenticated: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.submitUnauthenticated",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback/submit-unauthenticated"})
        }
      """
    )
  
    // @LINE:2
    def unauthenticatedFeedbackForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.unauthenticatedFeedbackForm",
      """
        function(service0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "beta-feedback-unauthenticated" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service0)])})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseProblemReportsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProblemReportsController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "problem_reports"})
        }
      """
    )
  
    // @LINE:17
    def submitSecure: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProblemReportsController.submitSecure",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "problem_reports_secure"})
        }
      """
    )
  
    // @LINE:13
    def reportForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProblemReportsController.reportForm",
      """
        function(secure0,csrfToken1,service2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problem_reports" + _qS([(""" + implicitly[QueryStringBindable[Option[Boolean]]].javascriptUnbind + """)("secure", secure0), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("csrfToken", csrfToken1), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service2)])})
        }
      """
    )
  
    // @LINE:15
    def reportFormNonJavaScript: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProblemReportsController.reportFormNonJavaScript",
      """
        function(service0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problem_reports_nonjs" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service0)])})
        }
      """
    )
  
    // @LINE:14
    def reportFormAjax: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProblemReportsController.reportFormAjax",
      """
        function(service0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problem_reports_ajax" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("service", service0)])})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseLanguageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def switchToEnglish: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LanguageController.switchToEnglish",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "switch-to-english"})
        }
      """
    )
  
    // @LINE:30
    def switchToWelsh: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LanguageController.switchToWelsh",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "switch-to-welsh"})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseSurveyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def survey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SurveyController.survey",
      """
        function(ticketId0,serviceId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "survey" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ticketId", ticketId0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("serviceId", serviceId1)])})
        }
      """
    )
  
    // @LINE:28
    def confirmation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SurveyController.confirmation",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "survey/confirmation"})
        }
      """
    )
  
    // @LINE:27
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SurveyController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitSurvey"})
        }
      """
    )
  
  }


}
