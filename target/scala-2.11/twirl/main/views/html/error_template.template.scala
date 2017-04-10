
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object error_template_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class error_template extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageTitle: String, heading: String, message: String)(implicit rh: Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import config.CFConfig
def /*4.2*/contentHeader/*4.15*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.19*/("""
  """),format.raw/*5.3*/("""<h1>"""),_display_(/*5.8*/heading),format.raw/*5.15*/("""</h1>
  """)))};def /*8.2*/mainContent/*8.13*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.17*/("""
  """),format.raw/*9.3*/("""<p>"""),_display_(/*9.7*/message),format.raw/*9.14*/("""</p>
""")))};
Seq[Any](format.raw/*1.114*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.4*/("""

"""),format.raw/*10.2*/("""

"""),_display_(/*12.2*/govuk_wrapper(appConfig = config.CFConfig, title = pageTitle, contentHeader = Some(contentHeader), mainContent = mainContent, enableLanguageSwitching = CFConfig.enableLanguageSwitching)))
      }
    }
  }

  def render(pageTitle:String,heading:String,message:String,rh:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle,heading,message)(rh,lang,messages)

  def f:((String,String,String) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle,heading,message) => (rh,lang,messages) => apply(pageTitle,heading,message)(rh,lang,messages)

  def ref: this.type = this

}


}

/**/
object error_template extends error_template_Scope0.error_template
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/error_template.scala.html
                  HASH: 931fec78f5fd12f8b0d915f57ccc073cc30d8571
                  MATRIX: 655->1|867->140|888->153|968->157|997->160|1027->165|1054->172|1085->184|1104->195|1184->199|1213->202|1242->206|1269->213|1315->113|1342->138|1369->181|1398->219|1427->222
                  LINES: 22->1|26->4|26->4|28->4|29->5|29->5|29->5|30->8|30->8|32->8|33->9|33->9|33->9|35->1|36->3|37->6|39->10|41->12
                  -- GENERATED --
              */
          