
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object contact_hmrc_form_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class contact_hmrc_form extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Form[controllers.ContactForm],String,Option[Boolean],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(contactForm: Form[controllers.ContactForm], externalContactHmrcUrl: String, renderFormOnly: Option[Boolean] = None)(implicit request: Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers._

Seq[Any](format.raw/*1.182*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/if(!renderFormOnly.getOrElse(false))/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
    """),format.raw/*6.5*/("""<header class="page-header">
        <h1>"""),_display_(/*7.14*/Messages("contact.heading")),format.raw/*7.41*/("""</h1>
    </header>
    <p>"""),_display_(/*9.9*/Html(
        Messages("contact.form.specific.query",
        uk.gov.hmrc.urls.Link.toExternalPage(url = "http://search2.hmrc.gov.uk/kb5/hmrc/contactus/home.page",
        value = Some("contact HMRC"),
        dataAttributes = Some(Map("journey-click" -> "contact-page:Click:Contact HMRC"))
        ).toHtml))),format.raw/*14.19*/("""</p>
    <p>"""),_display_(/*15.9*/Messages("contact.form.please.fill")),format.raw/*15.45*/("""</p>

    <h2>"""),_display_(/*17.10*/Messages("contact.form.how.help")),format.raw/*17.43*/("""</h2>
    <p>"""),_display_(/*18.9*/Messages("common.feedback.information.warning")),format.raw/*18.56*/("""</p>
""")))}),format.raw/*19.2*/("""

"""),format.raw/*21.1*/("""<form action=""""),_display_(/*21.16*/externalContactHmrcUrl),format.raw/*21.38*/("""" method="POST" class="form--feedback" novalidate="novalidate">
    <input type="hidden" name="csrfToken" value=""""),_display_(/*22.51*/contactForm("csrfToken")/*22.75*/.value),format.raw/*22.81*/(""""/>

    <input type="hidden" name="service" value=""""),_display_(/*24.49*/contactForm("service")/*24.71*/.value),format.raw/*24.77*/(""""/>

    <fieldset>
        """),_display_(/*27.10*/input(
        contactForm("contact-name"),
        '_label -> Messages("form.your.name"),
        '_divClass -> "form-field",
        '_inputClass -> "input--fullwidth"
        )),format.raw/*32.10*/("""
        """),_display_(/*33.10*/input(
        contactForm("contact-email"),
        '_label -> Messages("form.email.address"),
        '_divClass -> "form-field",
        '_inputClass -> "input--fullwidth",
        '_type -> "email"
        )),format.raw/*39.10*/("""
        """),_display_(/*40.10*/textArea(
        contactForm("contact-comments"),
        '_label -> Messages("form.your.comments"),
        '_divClass -> "form-field char-counter",
        '_inputClass -> "input--fullwidth",
        '_maxlength -> "2000",
        '_dataCharCounter -> "true",
        '_dataCharField -> "true"
        )),format.raw/*48.10*/("""

        """),format.raw/*50.9*/("""<input type="hidden" name="isJavascript" id="isJavascript" value=""""),_display_(/*50.76*/contactForm/*50.87*/.data.get("isJavascript")),format.raw/*50.112*/("""">
        <input type="hidden" name="referer" id="referer" value=""""),_display_(/*51.66*/contactForm/*51.77*/.data.get("referer")),format.raw/*51.97*/("""">

        <div class="form-field">
            <button id="submit" class="button" type="submit">"""),_display_(/*54.63*/Messages("form.send")),format.raw/*54.84*/("""</button>
        </div>

    </fieldset>
</form>"""))
      }
    }
  }

  def render(contactForm:Form[controllers.ContactForm],externalContactHmrcUrl:String,renderFormOnly:Option[Boolean],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(contactForm,externalContactHmrcUrl,renderFormOnly)(request,lang,messages)

  def f:((Form[controllers.ContactForm],String,Option[Boolean]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (contactForm,externalContactHmrcUrl,renderFormOnly) => (request,lang,messages) => apply(contactForm,externalContactHmrcUrl,renderFormOnly)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object contact_hmrc_form extends contact_hmrc_form_Scope0.contact_hmrc_form
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:26 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/contact_hmrc_form.scala.html
                  HASH: 245179f234e8d48abc25f453b73ec6e29d3f4058
                  MATRIX: 702->1|1022->181|1050->229|1077->231|1121->267|1160->269|1191->274|1259->316|1306->343|1359->371|1689->680|1728->693|1785->729|1827->744|1881->777|1921->791|1989->838|2025->844|2054->846|2096->861|2139->883|2280->997|2313->1021|2340->1027|2420->1080|2451->1102|2478->1108|2534->1137|2734->1316|2771->1326|3003->1537|3040->1547|3367->1853|3404->1863|3498->1930|3518->1941|3565->1966|3660->2034|3680->2045|3721->2065|3847->2164|3889->2185
                  LINES: 22->1|27->1|29->4|30->5|30->5|30->5|31->6|32->7|32->7|34->9|39->14|40->15|40->15|42->17|42->17|43->18|43->18|44->19|46->21|46->21|46->21|47->22|47->22|47->22|49->24|49->24|49->24|52->27|57->32|58->33|64->39|65->40|73->48|75->50|75->50|75->50|75->50|76->51|76->51|76->51|79->54|79->54
                  -- GENERATED --
              */
          