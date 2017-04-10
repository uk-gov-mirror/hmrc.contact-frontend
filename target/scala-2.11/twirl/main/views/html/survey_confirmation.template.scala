
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object survey_confirmation_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class survey_confirmation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.69*/("""

"""),_display_(/*3.2*/main(title = Messages("survey.title"), supportLinkEnabled = false)/*3.68*/ {_display_(Seq[Any](format.raw/*3.70*/("""

    """),format.raw/*5.5*/("""<header class="page-header">
        <h1>"""),_display_(/*6.14*/Messages("survey.confirmation.title")),format.raw/*6.51*/("""</h1>
    </header>

""")))}),format.raw/*9.2*/("""
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
object survey_confirmation extends survey_confirmation_Scope0.survey_confirmation
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/survey_confirmation.scala.html
                  HASH: 732753f5f1a5a0cb3512dc7843c6c5e76270d1c0
                  MATRIX: 644->1|806->68|834->71|908->137|947->139|979->145|1047->187|1104->224|1155->246
                  LINES: 22->1|27->1|29->3|29->3|29->3|31->5|32->6|32->6|35->9
                  -- GENERATED --
              */
          