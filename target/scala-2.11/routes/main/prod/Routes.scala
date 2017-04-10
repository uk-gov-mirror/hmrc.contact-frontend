
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/prod.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

package prod

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
    prod.RoutesPrefix.setPrefix(prefix)
    
    // @LINE:2
    app_Routes0 = Include(app.Routes.withPrefix(prefix + (if (prefix.endsWith("/")) "" else "/") + ""))
    // @LINE:3
    health_Routes1 = Include(health.Routes.withPrefix(prefix + (if (prefix.endsWith("/")) "" else "/") + ""))
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    app_Routes0.router.documentation,
    health_Routes1.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  @volatile private[this] var app_Routes0 = Include(app.Routes.withPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + ""))

  // @LINE:3
  @volatile private[this] var health_Routes1 = Include(health.Routes.withPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + ""))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case app_Routes0(handler) => handler
  
    // @LINE:3
    case health_Routes1(handler) => handler
  }
}
