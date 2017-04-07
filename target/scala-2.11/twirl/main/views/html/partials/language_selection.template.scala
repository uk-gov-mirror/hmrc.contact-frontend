
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object language_selection_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class language_selection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Boolean,Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(enableLanguageSwitching: Boolean)(implicit lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.79*/("""

"""),_display_(/*3.2*/if(enableLanguageSwitching)/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

"""),_display_(/*5.2*/if(lang.code == "cy")/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
"""),format.raw/*6.1*/("""<a title=""""),_display_(/*6.12*/Messages("language-switcher.english.hover")),format.raw/*6.55*/("""" href=""""),_display_(/*6.64*/controllers/*6.75*/.routes.LanguageController.switchToEnglish),format.raw/*6.117*/("""" data-journey-click="Language:Click:English">"""),_display_(/*6.164*/Messages("language-switcher.english")),format.raw/*6.201*/("""</a>
""")))}/*7.3*/else/*7.8*/{_display_(Seq[Any](format.raw/*7.9*/("""
"""),format.raw/*8.1*/("""<a title=""""),_display_(/*8.12*/Messages("language-switcher.welsh.hover")),format.raw/*8.53*/("""" href=""""),_display_(/*8.62*/controllers/*8.73*/.routes.LanguageController.switchToWelsh),format.raw/*8.113*/("""" data-journey-click="Language:Click:Welsh">"""),_display_(/*8.158*/Messages("language-switcher.welsh")),format.raw/*8.193*/("""</a>
""")))}),format.raw/*9.2*/("""
""")))}),format.raw/*10.2*/("""

"""))
      }
    }
  }

  def render(enableLanguageSwitching:Boolean,lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(enableLanguageSwitching)(lang,messages)

  def f:((Boolean) => (Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (enableLanguageSwitching) => (lang,messages) => apply(enableLanguageSwitching)(lang,messages)

  def ref: this.type = this

}


}

/**/
object language_selection extends language_selection_Scope0.language_selection
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:42 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/language_selection.scala.html
                  HASH: c2be4f924d6754770660e2e7184c41aeffe977c3
                  MATRIX: 577->1|749->78|777->81|812->108|851->110|879->113|908->134|947->136|974->137|1011->148|1074->191|1109->200|1128->211|1191->253|1265->300|1323->337|1346->344|1357->349|1394->350|1421->351|1458->362|1519->403|1554->412|1573->423|1634->463|1706->508|1762->543|1797->549|1829->551
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|29->5|29->5|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|31->7|31->7|31->7|32->8|32->8|32->8|32->8|32->8|32->8|32->8|32->8|33->9|34->10
                  -- GENERATED --
              */
          