
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/app.routes
// @DATE:Thu Mar 30 11:37:41 BST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:3
package com.kenshoo.play.metrics.javascript {
  import ReverseRouteContext.empty

  // @LINE:3
  class ReverseMetricsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def metrics: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "com.kenshoo.play.metrics.MetricsController.metrics",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/metrics"})
        }
      """
    )
  
  }


}
