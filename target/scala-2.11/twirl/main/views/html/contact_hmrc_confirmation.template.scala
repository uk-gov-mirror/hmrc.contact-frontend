
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object contact_hmrc_confirmation_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class contact_hmrc_confirmation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.85*/("""

"""),_display_(/*3.2*/main(title = Messages("contact.heading"), supportLinkEnabled = false)/*3.71*/ {_display_(Seq[Any](format.raw/*3.73*/("""
  """),_display_(/*4.4*/views/*4.9*/.html.partials.contact_hmrc_form_confirmation(ticketId)),format.raw/*4.64*/("""
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(ticketId:String,request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(ticketId)(request,lang,messages)

  def f:((String) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (ticketId) => (request,lang,messages) => apply(ticketId)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object contact_hmrc_confirmation extends contact_hmrc_confirmation_Scope0.contact_hmrc_confirmation
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/contact_hmrc_confirmation.scala.html
                  HASH: ada6f0550e229c74e150da7fd46379961b9d8895
                  MATRIX: 663->1|841->84|869->87|946->156|985->158|1014->162|1026->167|1101->222|1132->224
                  LINES: 22->1|27->1|29->3|29->3|29->3|30->4|30->4|30->4|31->5
                  -- GENERATED --
              */
          