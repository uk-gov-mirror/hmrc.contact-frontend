
package views.html.partials

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object error_feedback_inner_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class error_feedback_inner extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,Option[String],Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(actionUrl: String, csrfToken: Option[String], service: Option[String])(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html._

Seq[Any](format.raw/*1.138*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<h2>"""),_display_(/*4.6*/Messages("common.feedback.title")),format.raw/*4.39*/("""</h2>
<p>"""),_display_(/*5.5*/Messages("common.feedback.information.warning")),format.raw/*5.52*/("""</p>

<form action=""""),_display_(/*7.16*/actionUrl),format.raw/*7.25*/("""" method="POST" id="error-feedback-form" class="form--feedback" novalidate>
    """),_display_(/*8.6*/if(csrfToken.isDefined)/*8.29*/ {_display_(Seq[Any](format.raw/*8.31*/("""
    """),format.raw/*9.5*/("""<input type="hidden" name="csrfToken" value=""""),_display_(/*9.51*/{csrfToken.get}),format.raw/*9.66*/(""""/>
    """)))}),format.raw/*10.6*/("""

    """),_display_(/*12.6*/if(service.isDefined)/*12.27*/ {_display_(Seq[Any](format.raw/*12.29*/("""
    """),format.raw/*13.5*/("""<input type="hidden" name="service" value=""""),_display_(/*13.49*/{service.get}),format.raw/*13.62*/(""""/>
    """)))}),format.raw/*14.6*/("""

    """),format.raw/*16.5*/("""<fieldset>
        <legend class="visuallyhidden">"""),_display_(/*17.41*/Messages("common.feedback.title")),format.raw/*17.74*/("""</legend>
        <div class="form-group-compound">
            <label for="report-name" class="form-label">"""),_display_(/*19.58*/Messages("form.name")),format.raw/*19.79*/("""</label>
            <input id="report-name" maxlength="70" class="input--fullwidth form-control" name="report-name" type="text"  data-rule-letterswithbasicpunc="true" data-rule-required="true" data-msg-required='"""),_display_(/*20.206*/Messages("error.common.problem_report.name_mandatory")),format.raw/*20.260*/("""'>
        </div>
        <div class="form-group-compound">
            <label for="report-email" class="form-label">"""),_display_(/*23.59*/Messages("problem_report.email")),format.raw/*23.91*/("""</label>
            <input id="report-email" maxlength="255" class="input--fullwidth form-control" name="report-email" type="email" data-rule-required="true" data-rule-email="true" data-msg-required='"""),_display_(/*24.194*/Messages("error.common.problem_report.email_mandatory")),format.raw/*24.249*/("""'>
        </div>
        <div class="form-group-compound">
            <label for="report-action" class="form-label">"""),_display_(/*27.60*/Messages("problem_report.action")),format.raw/*27.93*/("""</label>
            <input id="report-action" maxlength="1000" class="input--fullwidth form-control" name="report-action" type="text" data-rule-required="true" data-msg-required='"""),_display_(/*28.173*/Messages("error.common.problem_report.action_mandatory")),format.raw/*28.229*/("""'>
        </div>
        <div class="form-group-compound">
            <label for="report-error" class="form-label">"""),_display_(/*31.59*/Messages("problem_report.error")),format.raw/*31.91*/("""</label>
            <input id="report-error" maxlength="1000" class="input--fullwidth form-control" name="report-error"  type="text" data-rule-required="true" data-msg-required='"""),_display_(/*32.172*/Messages("error.common.problem_report.error_mandatory")),format.raw/*32.227*/("""'>
        </div>
        <input type="hidden" name="isJavascript" value="false"/>
        <input type="hidden" name="referrer" value=""""),_display_(/*35.54*/{request.headers.get("referer").getOrElse("")}),format.raw/*35.100*/(""""/>
        <div class="form-field">
            <button id="report-submit" class="button" type="submit" data-journey-click="page:Click:Get help with this page Submit">"""),_display_(/*37.133*/Messages("form.send")),format.raw/*37.154*/("""</button>
        </div>
    </fieldset>
</form>

"""))
      }
    }
  }

  def render(actionUrl:String,csrfToken:Option[String],service:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(actionUrl,csrfToken,service)(request,lang,messages)

  def f:((String,Option[String],Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (actionUrl,csrfToken,service) => (request,lang,messages) => apply(actionUrl,csrfToken,service)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object error_feedback_inner extends error_feedback_inner_Scope0.error_feedback_inner
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:42 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/partials/error_feedback_inner.scala.html
                  HASH: 3ea40f2f907d5647a43e9559a16e21d31a31a83c
                  MATRIX: 692->1|960->137|987->176|1014->177|1044->182|1097->215|1132->225|1199->272|1246->293|1275->302|1381->383|1412->406|1451->408|1482->413|1554->459|1589->474|1628->483|1661->490|1691->511|1731->513|1763->518|1834->562|1868->575|1907->584|1940->590|2018->641|2072->674|2208->783|2250->804|2492->1018|2568->1072|2713->1190|2766->1222|2996->1424|3073->1479|3219->1598|3273->1631|3482->1812|3560->1868|3705->1986|3758->2018|3966->2198|4043->2253|4206->2389|4274->2435|4471->2604|4514->2625
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|30->5|32->7|32->7|33->8|33->8|33->8|34->9|34->9|34->9|35->10|37->12|37->12|37->12|38->13|38->13|38->13|39->14|41->16|42->17|42->17|44->19|44->19|45->20|45->20|48->23|48->23|49->24|49->24|52->27|52->27|53->28|53->28|56->31|56->31|57->32|57->32|60->35|60->35|62->37|62->37
                  -- GENERATED --
              */
          