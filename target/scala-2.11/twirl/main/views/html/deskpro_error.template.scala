
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object deskpro_error_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class deskpro_error extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers._

Seq[Any](format.raw/*1.69*/("""

"""),_display_(/*4.2*/main(title = Messages("contact.heading"), supportLinkEnabled = false)/*4.71*/ {_display_(Seq[Any](format.raw/*4.73*/("""

"""),format.raw/*6.1*/("""<header class="page-header">
    <h1>"""),_display_(/*7.10*/Messages("global.error.InternalServerError500.heading")),format.raw/*7.65*/("""</h1>
</header>

<article id="report-confirmation-no-data">
    <p>"""),_display_(/*11.9*/Messages("deskpro.error.problem.sending")),format.raw/*11.50*/("""</p>
    <p>"""),_display_(/*12.9*/Messages("please.try.later")),format.raw/*12.37*/("""</p>
</article>

""")))}),format.raw/*15.2*/("""
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
object deskpro_error extends deskpro_error_Scope0.deskpro_error
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/deskpro_error.scala.html
                  HASH: aaca4507b153b7d56ae5c3fe9813cc7581de5ace
                  MATRIX: 632->1|838->68|866->117|943->186|982->188|1010->190|1074->228|1149->283|1243->351|1305->392|1344->405|1393->433|1441->451
                  LINES: 22->1|27->1|29->4|29->4|29->4|31->6|32->7|32->7|36->11|36->11|37->12|37->12|40->15
                  -- GENERATED --
              */
          