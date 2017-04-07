
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object govuk_wrapper_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class govuk_wrapper extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template11[config.AppConfig,String,Option[String],Option[Html],Html,Boolean,Html,Boolean,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(appConfig: config.AppConfig,
  title: String,
  bodyClasses: Option[String] = None,
  contentHeader: Option[Html] = None,
  mainContent: Html = HtmlFormat.empty,
  userLoggedIn: Boolean = true,
  getHelpForm: Html  = HtmlFormat.empty, enableLanguageSwitching : Boolean)(implicit request: Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import layouts.{govuk_template => hmrcGovUkTemplate}
import uk.gov.hmrc.play.views.html.{layouts => uiLayouts}
def /*12.2*/head/*12.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.10*/("""
    """),_display_(/*13.6*/uiLayouts/*13.15*/.head(
      linkElem = None,
      headScripts = None)),format.raw/*15.26*/("""
    """),format.raw/*16.5*/("""<meta name="format-detection" content="telephone=no" />
""")))};def /*19.2*/insideHeader/*19.14*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any]())};def /*21.2*/afterHeader/*21.13*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any]())};def /*23.2*/bodyEnd/*23.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*23.13*/("""
    """),_display_(/*24.6*/uiLayouts/*24.15*/.footer(
      analyticsToken = Some(appConfig.analyticsToken),
      analyticsHost = appConfig.analyticsHost,
      ssoUrl = None,
      scriptElem = None,
      gaCalls = None)),format.raw/*29.22*/("""
""")))};def /*32.2*/footerTop/*32.11*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any]())};def /*33.2*/footerLinks/*33.13*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any]())};def /*35.2*/serviceInfo/*35.13*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*35.17*/("""
    """),_display_(/*36.6*/uiLayouts/*36.15*/.serviceInfo(
      betaBanner = HtmlFormat.empty,
      includeGridWrapper = false,
      serviceInfoContent = None)),format.raw/*39.33*/("""
""")))};def /*42.2*/mainContentHeader/*42.19*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*42.23*/("""
    """),_display_(/*43.6*/if(contentHeader.isDefined)/*43.33*/ {_display_(Seq[Any](format.raw/*43.35*/("""
        """),_display_(/*44.10*/uiLayouts/*44.19*/.main_content_header(contentHeader = contentHeader.get)),format.raw/*44.74*/("""
    """)))}),format.raw/*45.6*/("""
""")))};def /*48.2*/content/*48.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*48.13*/("""
    """),_display_(/*49.6*/uiLayouts/*49.15*/.main_content(
      article = mainContent,
      mainContentHeader = mainContentHeader,
      serviceInfo = serviceInfo,
      getHelpForm = getHelpForm)),format.raw/*53.33*/("""
""")))};
Seq[Any](format.raw/*7.140*/("""

"""),format.raw/*11.1*/("""
"""),format.raw/*17.2*/("""

"""),format.raw/*19.19*/("""

"""),format.raw/*21.18*/("""

"""),format.raw/*30.2*/("""

"""),format.raw/*32.16*/("""
"""),format.raw/*33.18*/("""

"""),format.raw/*40.2*/("""

"""),format.raw/*46.2*/("""

"""),format.raw/*54.2*/("""

"""),_display_(/*56.2*/hmrcGovUkTemplate(Some(title), bodyClasses)/*56.45*/(head, bodyEnd, insideHeader, HtmlFormat.empty, footerTop, Some(uiLayouts.footer_links(Some(partials.language_selection(enableLanguageSwitching)))),true)/*56.198*/(content)),format.raw/*56.207*/("""
"""))
      }
    }
  }

  def render(appConfig:config.AppConfig,title:String,bodyClasses:Option[String],contentHeader:Option[Html],mainContent:Html,userLoggedIn:Boolean,getHelpForm:Html,enableLanguageSwitching:Boolean,request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(appConfig,title,bodyClasses,contentHeader,mainContent,userLoggedIn,getHelpForm,enableLanguageSwitching)(request,lang,messages)

  def f:((config.AppConfig,String,Option[String],Option[Html],Html,Boolean,Html,Boolean) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (appConfig,title,bodyClasses,contentHeader,mainContent,userLoggedIn,getHelpForm,enableLanguageSwitching) => (request,lang,messages) => apply(appConfig,title,bodyClasses,contentHeader,mainContent,userLoggedIn,getHelpForm,enableLanguageSwitching)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object govuk_wrapper extends govuk_wrapper_Scope0.govuk_wrapper
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/govuk_wrapper.scala.html
                  HASH: f98a3719807dadea29d5532af6f69aaa388f1b3d
                  MATRIX: 711->1|1234->452|1246->456|1327->460|1359->466|1377->475|1453->530|1485->535|1565->595|1586->607|1664->615|1684->626|1762->634|1777->641|1858->645|1890->651|1908->660|2107->838|2132->843|2150->852|2228->859|2248->870|2326->878|2346->889|2427->893|2459->899|2477->908|2615->1025|2640->1030|2666->1047|2747->1051|2779->1057|2815->1084|2855->1086|2892->1096|2910->1105|2986->1160|3022->1166|3047->1171|3062->1178|3143->1182|3175->1188|3193->1197|3368->1351|3410->335|3439->450|3467->592|3497->612|3527->631|3556->840|3586->857|3615->875|3644->1027|3673->1168|3702->1353|3731->1356|3783->1399|3946->1552|3977->1561
                  LINES: 22->1|33->12|33->12|35->12|36->13|36->13|38->15|39->16|40->19|40->19|42->21|42->21|44->23|44->23|46->23|47->24|47->24|52->29|53->32|53->32|55->33|55->33|57->35|57->35|59->35|60->36|60->36|63->39|64->42|64->42|66->42|67->43|67->43|67->43|68->44|68->44|68->44|69->45|70->48|70->48|72->48|73->49|73->49|77->53|79->7|81->11|82->17|84->19|86->21|88->30|90->32|91->33|93->40|95->46|97->54|99->56|99->56|99->56|99->56
                  -- GENERATED --
              */
          