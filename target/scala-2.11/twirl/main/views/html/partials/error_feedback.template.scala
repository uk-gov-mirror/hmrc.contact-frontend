
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object error_feedback_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class error_feedback extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,Option[String],Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(actionUrl: String, csrfToken: Option[String], service: Option[String])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html._

Seq[Any](format.raw/*1.138*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<div class="report-error">
    <a class="report-error__toggle js-visible" id="get-help-action" href="#error-feedback-form">"""),_display_(/*5.98*/Messages("common.feedback.get.help")),format.raw/*5.134*/("""</a>
    <div class="report-error__content js-hidden">
        """),_display_(/*7.10*/views/*7.15*/.html.partials.error_feedback_inner(actionUrl, csrfToken, service)),format.raw/*7.81*/("""
    """),format.raw/*8.5*/("""</div>
</div>
"""))
      }
    }
  }

  def render(actionUrl:String,csrfToken:Option[String],service:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(actionUrl,csrfToken,service)(request,lang,messages)

  def f:((String,Option[String],Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (actionUrl,csrfToken,service) => (request,lang,messages) => apply(actionUrl,csrfToken,service)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object error_feedback extends error_feedback_Scope0.error_feedback
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:42 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/error_feedback.scala.html
                  HASH: c84a103854e9b41c056a5c82ccaec4349ef885af
                  MATRIX: 680->1|948->137|975->176|1002->177|1152->301|1209->337|1299->401|1312->406|1398->472|1429->477
                  LINES: 22->1|27->1|28->3|29->4|30->5|30->5|32->7|32->7|32->7|33->8
                  -- GENERATED --
              */
          