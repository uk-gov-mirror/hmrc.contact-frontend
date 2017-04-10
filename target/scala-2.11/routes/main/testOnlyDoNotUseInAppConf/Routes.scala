
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/testOnlyDoNotUseInAppConf.routes
// @DATE:Mon Apr 10 13:51:25 BST 2017

package testOnlyDoNotUseInAppConf

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
    testOnlyDoNotUseInAppConf.RoutesPrefix.setPrefix(prefix)
    
    // @LINE:13
    prod_Routes0 = Include(prod.Routes.withPrefix(prefix + (if (prefix.endsWith("/")) "" else "/") + ""))
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    prod_Routes0.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:13
  @volatile private[this] var prod_Routes0 = Include(prod.Routes.withPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + ""))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:13
    case prod_Routes0(handler) => handler
  }
}
