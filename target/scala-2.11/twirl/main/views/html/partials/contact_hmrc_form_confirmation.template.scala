
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object contact_hmrc_form_confirmation_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class contact_hmrc_form_confirmation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.85*/("""

"""),format.raw/*3.1*/("""<header class="page-header">
  <h1>"""),_display_(/*4.8*/Messages("contact.heading")),format.raw/*4.35*/("""</h1>
</header>

"""),_display_(/*7.2*/ticket_created_body(ticketId, None)),format.raw/*7.37*/("""
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
object contact_hmrc_form_confirmation extends contact_hmrc_form_confirmation_Scope0.contact_hmrc_form_confirmation
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:42 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/contact_hmrc_form_confirmation.scala.html
                  HASH: 2f9fab841265552975647c722637b0a7ab9a23de
                  MATRIX: 682->1|860->84|888->86|949->122|996->149|1039->167|1094->202
                  LINES: 22->1|27->1|29->3|30->4|30->4|33->7|33->7
                  -- GENERATED --
              */
          