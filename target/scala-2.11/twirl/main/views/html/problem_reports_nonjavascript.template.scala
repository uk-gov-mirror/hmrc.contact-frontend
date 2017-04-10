
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object problem_reports_nonjavascript_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class problem_reports_nonjavascript extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(actionUrl: String, service: Option[String])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html._
import play.filters.csrf.CSRF

Seq[Any](format.raw/*1.111*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(title = "", supportLinkEnabled = false)/*5.46*/ {_display_(Seq[Any](format.raw/*5.48*/("""

        """),format.raw/*7.9*/("""<div>
            <div class="report-error__content">
                """),_display_(/*9.18*/views/*9.23*/.html.partials.error_feedback_inner(actionUrl, CSRF.getToken(request).map(_.value), service)),format.raw/*9.115*/("""
            """),format.raw/*10.13*/("""</div>
        </div>

""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(actionUrl:String,service:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(actionUrl,service)(request,lang,messages)

  def f:((String,Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (actionUrl,service) => (request,lang,messages) => apply(actionUrl,service)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object problem_reports_nonjavascript extends problem_reports_nonjavascript_Scope0.problem_reports_nonjavascript
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/problem_reports_nonjavascript.scala.html
                  HASH: c67cf622201ff9fc7652e98dffd36770ed543e30
                  MATRIX: 686->1|957->110|984->180|1011->182|1063->226|1102->228|1138->238|1235->309|1248->314|1361->406|1402->419|1456->443
                  LINES: 22->1|28->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|35->10|38->13
                  -- GENERATED --
              */
          