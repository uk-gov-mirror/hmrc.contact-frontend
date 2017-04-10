
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/contact.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

package controllers;

import contact.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseContactHmrcController ContactHmrcController = new controllers.ReverseContactHmrcController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplicationController ApplicationController = new controllers.ReverseApplicationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePartialsController PartialsController = new controllers.ReversePartialsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFeedbackController FeedbackController = new controllers.ReverseFeedbackController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProblemReportsController ProblemReportsController = new controllers.ReverseProblemReportsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLanguageController LanguageController = new controllers.ReverseLanguageController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSurveyController SurveyController = new controllers.ReverseSurveyController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseContactHmrcController ContactHmrcController = new controllers.javascript.ReverseContactHmrcController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplicationController ApplicationController = new controllers.javascript.ReverseApplicationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePartialsController PartialsController = new controllers.javascript.ReversePartialsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFeedbackController FeedbackController = new controllers.javascript.ReverseFeedbackController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProblemReportsController ProblemReportsController = new controllers.javascript.ReverseProblemReportsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLanguageController LanguageController = new controllers.javascript.ReverseLanguageController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSurveyController SurveyController = new controllers.javascript.ReverseSurveyController(RoutesPrefix.byNamePrefix());
  }

}
