
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object feedback_form_confirmation_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class feedback_form_confirmation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.85*/("""

"""),format.raw/*3.1*/("""<header class="page-header">
    <h1>"""),_display_(/*4.10*/Messages("common.feedback.confirmation.heading")),format.raw/*4.58*/("""</h1>
</header>
<section id="content" class="l-constrained--topBordered">

    <article id="report-confirmation">
        <h2 id="feedback-thank-you-header">"""),_display_(/*9.45*/Messages("common.thank.you")),format.raw/*9.73*/("""</h2>
        <input id="ticketId" type="hidden" value=""""),_display_(/*10.52*/ticketId),format.raw/*10.60*/(""""/>
        <p>"""),_display_(/*11.13*/Messages("common.feedback.confirmation.message")),format.raw/*11.61*/("""</p>
    </article>
</section>
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
object feedback_form_confirmation extends feedback_form_confirmation_Scope0.feedback_form_confirmation
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:26 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/feedback_form_confirmation.scala.html
                  HASH: a2f94e6ff4b0589728ef463f2d88c0a224239813
                  MATRIX: 674->1|852->84|880->86|944->124|1012->172|1196->330|1244->358|1328->415|1357->423|1400->439|1469->487
                  LINES: 22->1|27->1|29->3|30->4|30->4|35->9|35->9|36->10|36->10|37->11|37->11
                  -- GENERATED --
              */
          