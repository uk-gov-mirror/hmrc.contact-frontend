
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object problem_reports_confirmation_nonjavascript_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class problem_reports_confirmation_nonjavascript extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String, thankYouMessage: Option[String])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/pageTitle/*3.11*/ = {{Messages("common.thank.you")}};
Seq[Any](format.raw/*1.118*/("""

"""),format.raw/*3.45*/("""
"""),_display_(/*4.2*/main(title = pageTitle, supportLinkEnabled = false)/*4.53*/  {_display_(Seq[Any](format.raw/*4.56*/("""
"""),format.raw/*5.1*/("""<header class="page-header">
    <h1>"""),_display_(/*6.10*/pageTitle),format.raw/*6.19*/("""</h1>
</header>
    <article id="report-confirmation">
        """),_display_(/*9.10*/ticket_created_body(ticketId, thankYouMessage)),format.raw/*9.56*/("""
    """),format.raw/*10.5*/("""</article>

""")))}),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(ticketId:String,thankYouMessage:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(ticketId,thankYouMessage)(request,lang,messages)

  def f:((String,Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (ticketId,thankYouMessage) => (request,lang,messages) => apply(ticketId,thankYouMessage)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object problem_reports_confirmation_nonjavascript extends problem_reports_confirmation_nonjavascript_Scope0.problem_reports_confirmation_nonjavascript
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/problem_reports_confirmation_nonjavascript.scala.html
                  HASH: ad66942a4f711e116411eea6ef1be5cd53eb8e85
                  MATRIX: 712->1|906->120|923->129|988->117|1017->163|1044->165|1103->216|1143->219|1170->220|1234->258|1263->267|1353->331|1419->377|1451->382|1494->395
                  LINES: 22->1|26->3|26->3|27->1|29->3|30->4|30->4|30->4|31->5|32->6|32->6|35->9|35->9|36->10|38->12
                  -- GENERATED --
              */
          