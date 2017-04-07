
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object contact_hmrc_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class contact_hmrc extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[controllers.ContactForm],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(contactForm: Form[controllers.ContactForm])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers._

Seq[Any](format.raw/*1.111*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(title = Messages("contact.heading"), supportLinkEnabled = false)/*5.71*/ {_display_(Seq[Any](format.raw/*5.73*/("""
    """),_display_(/*6.6*/views/*6.11*/.html.partials.contact_hmrc_form(contactForm, routes.ContactHmrcController.submit.url)),format.raw/*6.97*/("""
""")))}))
      }
    }
  }

  def render(contactForm:Form[controllers.ContactForm],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(contactForm)(request,lang,messages)

  def f:((Form[controllers.ContactForm]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (contactForm) => (request,lang,messages) => apply(contactForm)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object contact_hmrc extends contact_hmrc_Scope0.contact_hmrc
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/contact_hmrc.scala.html
                  HASH: c207619f196494788a1c201027c856085c5d911a
                  MATRIX: 660->1|909->110|937->158|964->160|1041->229|1080->231|1111->237|1124->242|1230->328
                  LINES: 22->1|27->1|29->4|30->5|30->5|30->5|31->6|31->6|31->6
                  -- GENERATED --
              */
          