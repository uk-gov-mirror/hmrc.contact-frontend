
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/app.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

package app

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
    app.RoutesPrefix.setPrefix(prefix)
    
    // @LINE:1
    contact_Routes0 = Include(contact.Routes.withPrefix(prefix + (if (prefix.endsWith("/")) "" else "/") + "contact"))
    // @LINE:2
    template_Routes1 = Include(template.Routes.withPrefix(prefix + (if (prefix.endsWith("/")) "" else "/") + "template"))
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    contact_Routes0.router.documentation,
    template_Routes1.router.documentation,
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/metrics""", """@com.kenshoo.play.metrics.MetricsController@.metrics"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  @volatile private[this] var contact_Routes0 = Include(contact.Routes.withPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + "contact"))

  // @LINE:2
  @volatile private[this] var template_Routes1 = Include(template.Routes.withPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + "template"))

  // @LINE:3
  private[this] lazy val com_kenshoo_play_metrics_MetricsController_metrics2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/metrics")))
  )
  private[this] lazy val com_kenshoo_play_metrics_MetricsController_metrics2_invoker = createInvoker(
    play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[com.kenshoo.play.metrics.MetricsController]).metrics,
    HandlerDef(this.getClass.getClassLoader,
      "app",
      "com.kenshoo.play.metrics.MetricsController",
      "metrics",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/metrics"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case contact_Routes0(handler) => handler
  
    // @LINE:2
    case template_Routes1(handler) => handler
  
    // @LINE:3
    case com_kenshoo_play_metrics_MetricsController_metrics2_route(params) =>
      call { 
        com_kenshoo_play_metrics_MetricsController_metrics2_invoker.call(play.api.Play.routesCompilerMaybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[com.kenshoo.play.metrics.MetricsController]).metrics)
      }
  }
}
