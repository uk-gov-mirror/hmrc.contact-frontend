
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[String,Boolean,Boolean,Option[String],Option[String],Html,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, 
  userLoggedIn: Boolean = true, 
  supportLinkEnabled: Boolean = true, 
  bodyClasses: Option[String] = None,
  service: Option[String] = None)(mainContent: Html)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import config.CFConfig
import uk.gov.hmrc.play.views.html.layouts
def /*10.2*/getHelpForm/*10.13*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*10.17*/("""
  """),_display_(/*11.4*/if(supportLinkEnabled)/*11.26*/ {_display_(Seq[Any](format.raw/*11.28*/("""
    """),_display_(/*12.6*/partials/*12.14*/.error_feedback(config.CFConfig.externalReportProblemSecureUrl, play.filters.csrf.CSRF.getToken(request).map(_.value), service)),format.raw/*12.141*/("""
  """)))}),format.raw/*13.4*/("""
""")))};
Seq[Any](format.raw/*5.118*/("""

"""),format.raw/*9.1*/("""
"""),format.raw/*14.2*/("""

"""),_display_(/*16.2*/govuk_wrapper(
  appConfig = config.CFConfig,
  title = title,
  bodyClasses = bodyClasses,
  mainContent = layouts.article(mainContent),
  userLoggedIn = userLoggedIn,
  getHelpForm = getHelpForm,
  enableLanguageSwitching = CFConfig.enableLanguageSwitching)),format.raw/*23.62*/("""
"""))
      }
    }
  }

  def render(title:String,userLoggedIn:Boolean,supportLinkEnabled:Boolean,bodyClasses:Option[String],service:Option[String],mainContent:Html,request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(title,userLoggedIn,supportLinkEnabled,bodyClasses,service)(mainContent)(request,lang,messages)

  def f:((String,Boolean,Boolean,Option[String],Option[String]) => (Html) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (title,userLoggedIn,supportLinkEnabled,bodyClasses,service) => (mainContent) => (request,lang,messages) => apply(title,userLoggedIn,supportLinkEnabled,bodyClasses,service)(mainContent)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/main.scala.html
                  HASH: 3e8b2338bc9a74ae464a382568d6f83008271475
                  MATRIX: 672->1|1060->317|1080->328|1161->332|1191->336|1222->358|1262->360|1294->366|1311->374|1460->501|1494->505|1536->245|1564->315|1592->507|1621->510|1901->769
                  LINES: 22->1|31->10|31->10|33->10|34->11|34->11|34->11|35->12|35->12|35->12|36->13|38->5|40->9|41->14|43->16|50->23
                  -- GENERATED --
              */
          