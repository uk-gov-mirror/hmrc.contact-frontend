
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/app.routes
// @DATE:Thu Mar 30 11:37:41 BST 2017

package com.kenshoo.play.metrics;

import app.RoutesPrefix;

public class routes {
  
  public static final com.kenshoo.play.metrics.ReverseMetricsController MetricsController = new com.kenshoo.play.metrics.ReverseMetricsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final com.kenshoo.play.metrics.javascript.ReverseMetricsController MetricsController = new com.kenshoo.play.metrics.javascript.ReverseMetricsController(RoutesPrefix.byNamePrefix());
  }

}