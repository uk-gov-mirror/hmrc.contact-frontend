
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object feedback_confirmation_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class feedback_confirmation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Option[uk.gov.hmrc.play.frontend.auth.AuthContext],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId:String, user: Option[uk.gov.hmrc.play.frontend.auth.AuthContext])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.142*/("""

"""),_display_(/*3.2*/main(title = Messages("common.feedback.heading"), userLoggedIn = user.isDefined)/*3.82*/ {_display_(Seq[Any](format.raw/*3.84*/("""
    """),_display_(/*4.6*/views/*4.11*/.html.partials.feedback_form_confirmation(ticketId)),format.raw/*4.62*/("""
""")))}))
      }
    }
  }

  def render(ticketId:String,user:Option[uk.gov.hmrc.play.frontend.auth.AuthContext],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(ticketId,user)(request,lang,messages)

  def f:((String,Option[uk.gov.hmrc.play.frontend.auth.AuthContext]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (ticketId,user) => (request,lang,messages) => apply(ticketId,user)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object feedback_confirmation extends feedback_confirmation_Scope0.feedback_confirmation
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/feedback_confirmation.scala.html
                  HASH: 5e6701d7099fbba74cb31f83290c94ce2cb0f7ea
                  MATRIX: 706->1|942->141|970->144|1058->224|1097->226|1128->232|1141->237|1212->288
                  LINES: 22->1|27->1|29->3|29->3|29->3|30->4|30->4|30->4
                  -- GENERATED --
              */
          