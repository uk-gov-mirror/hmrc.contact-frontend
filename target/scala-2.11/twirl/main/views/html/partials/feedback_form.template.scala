
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object feedback_form_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class feedback_form extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Form[controllers.FeedbackForm],String,Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(feedbackForm: Form[controllers.FeedbackForm],
  externalFeedbackUrl: String,
  service: Option[String] = None)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers._
import views.helpers.ServiceParameter.extractServiceParameter

Seq[Any](format.raw/*3.99*/("""

"""),format.raw/*6.1*/("""
"""),format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<header class="page-header">
    <h1>"""),_display_(/*10.10*/Messages("common.feedback.heading")),format.raw/*10.45*/("""</h1>
</header>

<form id="feedback-form" action=""""),_display_(/*13.35*/externalFeedbackUrl),format.raw/*13.54*/("""" method="POST" class="form--feedback" novalidate>
    <input type="hidden" name="csrfToken" value=""""),_display_(/*14.51*/feedbackForm("csrfToken")/*14.76*/.value),format.raw/*14.82*/(""""/>

    <input type="hidden" name="service" value=""""),_display_(/*16.49*/extractServiceParameter(feedbackForm, service)),format.raw/*16.95*/(""""/>

    <fieldset>
        """),_display_(/*19.10*/inputRadioGroup(
        feedbackForm("feedback-rating"),
        Vector(("5",Messages("form.online.services.very_good")), ("4",Messages("form.online.services.good")), ("3",Messages("form.online.services.neutral")), ("2",Messages("form.online.services.bad")), ("1",Messages("form.online.services.very_bad"))),
        '_legend -> Messages("form.online.services"),
        '_stackedLabel -> true,
        '_labelClass -> "label--inlineRadio--overhead"
        )),format.raw/*25.10*/("""
        """),_display_(/*26.10*/input(
        feedbackForm("feedback-name"),
        '_label -> Messages("form.name"),
        '_divClass -> "form-field",
        '_inputClass -> "input--fullwidth"
        )),format.raw/*31.10*/("""
        """),_display_(/*32.10*/input(
        feedbackForm("feedback-email"),
        '_label -> Messages("form.email.address"),
        '_divClass -> "form-field",
        '_inputClass -> "input--fullwidth",
        '_type -> "email"
        )),format.raw/*38.10*/("""
        """),_display_(/*39.10*/textArea(
        feedbackForm("feedback-comments"),
        '_label -> Messages("form.comments"),
        '_info -> Messages("common.feedback.information.warning"),
        '_divClass -> "form-field char-counter",
        '_inputClass -> "input--fullwidth",
        '_maxlength -> "2000",
        '_dataCharCounter -> "true",
        '_dataCharField -> "true"
        )),format.raw/*48.10*/("""
        """),format.raw/*49.9*/("""<input type="hidden" name="isJavascript" id="isJavascript" value=""""),_display_(/*49.76*/feedbackForm/*49.88*/.data.get("isJavascript")),format.raw/*49.113*/("""">
        <input type="hidden" name="referer" id="referer" value=""""),_display_(/*50.66*/feedbackForm/*50.78*/.data.get("referer")),format.raw/*50.98*/("""">

        <div class="form-field">
            <button id="submit" class="button" type="submit">"""),_display_(/*53.63*/Messages("form.send")),format.raw/*53.84*/("""</button>
        </div>

    </fieldset>
</form>"""))
      }
    }
  }

  def render(feedbackForm:Form[controllers.FeedbackForm],externalFeedbackUrl:String,service:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(feedbackForm,externalFeedbackUrl,service)(request,lang,messages)

  def f:((Form[controllers.FeedbackForm],String,Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (feedbackForm,externalFeedbackUrl,service) => (request,lang,messages) => apply(feedbackForm,externalFeedbackUrl,service)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object feedback_form extends feedback_form_Scope0.feedback_form
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/feedback_form.scala.html
                  HASH: e44cac470773301d4021d2cea26b4e17d9e78320
                  MATRIX: 694->1|1071->177|1099->225|1126->289|1153->290|1218->328|1274->363|1352->414|1392->433|1520->534|1554->559|1581->565|1661->618|1728->664|1784->693|2265->1153|2302->1163|2499->1339|2536->1349|2770->1562|2807->1572|3198->1942|3234->1951|3328->2018|3349->2030|3396->2055|3491->2123|3512->2135|3553->2155|3679->2254|3721->2275
                  LINES: 22->1|30->3|32->6|33->8|34->9|35->10|35->10|38->13|38->13|39->14|39->14|39->14|41->16|41->16|44->19|50->25|51->26|56->31|57->32|63->38|64->39|73->48|74->49|74->49|74->49|74->49|75->50|75->50|75->50|78->53|78->53
                  -- GENERATED --
              */
          