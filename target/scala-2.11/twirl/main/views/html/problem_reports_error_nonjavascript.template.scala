
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object problem_reports_error_nonjavascript_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class problem_reports_error_nonjavascript extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/pageTitle/*3.11*/ = {{Messages("common.problem_report.error_nojavascript_title")}};
Seq[Any](format.raw/*1.69*/("""

"""),format.raw/*3.75*/("""
"""),_display_(/*4.2*/main(title = pageTitle, supportLinkEnabled = false)/*4.53*/ {_display_(Seq[Any](format.raw/*4.55*/("""
"""),format.raw/*5.1*/("""<header class="page-header">
    <h1>"""),_display_(/*6.10*/pageTitle),format.raw/*6.19*/("""</h1>
</header>
    <article id="report-confirmation-no-data">
        <p>"""),_display_(/*9.13*/Messages("please.try.later")),format.raw/*9.41*/("""</p>
    </article>
""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply()(request,lang,messages)

  def f:(() => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = () => (request,lang,messages) => apply()(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object problem_reports_error_nonjavascript extends problem_reports_error_nonjavascript_Scope0.problem_reports_error_nonjavascript
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/problem_reports_error_nonjavascript.scala.html
                  HASH: 0d79c5a3c5851fa4c7e3445c24097299f9684066
                  MATRIX: 676->1|821->71|838->80|932->68|961->144|988->146|1047->197|1086->199|1113->200|1177->238|1206->247|1307->322|1355->350|1406->371
                  LINES: 22->1|26->3|26->3|27->1|29->3|30->4|30->4|30->4|31->5|32->6|32->6|35->9|35->9|37->11
                  -- GENERATED --
              */
          