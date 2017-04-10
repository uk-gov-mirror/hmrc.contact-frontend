
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object survey_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class survey extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String, serviceId: String)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers.form
import controllers.SurveyFormFields

Seq[Any](format.raw/*1.104*/("""

"""),format.raw/*5.1*/("""


"""),_display_(/*8.2*/main(title = Messages("survey.title"), bodyClasses = Some("full-width"))/*8.74*/ {_display_(Seq[Any](format.raw/*8.76*/("""

	"""),format.raw/*10.2*/("""<header class="page-header">
		<h1>"""),_display_(/*11.8*/Messages("survey.title")),format.raw/*11.32*/("""</h1>
	</header>

	"""),_display_(/*14.3*/form(action=controllers.routes.SurveyController.submit, 'class -> "form")/*14.76*/ {_display_(Seq[Any](format.raw/*14.78*/("""

        """),format.raw/*16.9*/("""<input type="hidden" value=""""),_display_(/*16.38*/ticketId),format.raw/*16.46*/("""" id="ticket-id" name="ticket-id">
        <input type="hidden" value=""""),_display_(/*17.38*/serviceId),format.raw/*17.47*/("""" id="service-id" name="service-id">


		<fieldset class="form-field-group">
		    <legend class="float--none">"""),_display_(/*21.36*/Messages("survey.was.answer.helpful.question")),format.raw/*21.82*/("""</legend>
		    <label class="block-label--stacked" for="helpful-strongly-agree">
		        <input type="radio" id="helpful-strongly-agree" name=""""),_display_(/*23.66*/{SurveyFormFields.helpful}),format.raw/*23.92*/("""" value="5">
				"""),_display_(/*24.6*/Messages("survey.strongly.agree.response")),format.raw/*24.48*/("""
		    """),format.raw/*25.7*/("""</label>
		    <label class="block-label--stacked" for="helpful-agree">
		        <input type="radio" id="helpful-agree" name=""""),_display_(/*27.57*/{SurveyFormFields.helpful}),format.raw/*27.83*/("""" value="4">
				"""),_display_(/*28.6*/Messages("survey.agree.response")),format.raw/*28.39*/("""
		    """),format.raw/*29.7*/("""</label>
		    <label class="block-label--stacked" for="helpful-neutral">
		        <input type="radio" id="helpful-neutral" name=""""),_display_(/*31.59*/{SurveyFormFields.helpful}),format.raw/*31.85*/("""" value="3">
				"""),_display_(/*32.6*/Messages("survey.neutral.response")),format.raw/*32.41*/("""
		    """),format.raw/*33.7*/("""</label>
		    <label class="block-label--stacked" for="helpful-disagree">
		        <input type="radio" id="helpful-disagree" name=""""),_display_(/*35.60*/{SurveyFormFields.helpful}),format.raw/*35.86*/("""" value="2">
				"""),_display_(/*36.6*/Messages("survey.disagree.response")),format.raw/*36.42*/("""
		    """),format.raw/*37.7*/("""</label>
		    <label class="block-label--stacked" for="helpful-strongly-disagree">
		        <input type="radio" id="helpful-strongly-disagree" name=""""),_display_(/*39.69*/{SurveyFormFields.helpful}),format.raw/*39.95*/("""" value="1">
				"""),_display_(/*40.6*/Messages("survey.strongly.disagree.response")),format.raw/*40.51*/("""
		    """),format.raw/*41.7*/("""</label>
		</fieldset>

		<fieldset class="form-field-group">
		    <legend class="float--none">"""),_display_(/*45.36*/Messages("survey.satisfied.with.speed.question")),format.raw/*45.84*/("""</legend>
		    <label class="block-label--stacked" for="speed-strongly-agree">
		        <input type="radio" id="speed-strongly-agree" name=""""),_display_(/*47.64*/{SurveyFormFields.speed}),format.raw/*47.88*/("""" value="5">
				"""),_display_(/*48.6*/Messages("survey.strongly.agree.response")),format.raw/*48.48*/("""
		    """),format.raw/*49.7*/("""</label>
		    <label class="block-label--stacked" for="speed-agree">
		        <input type="radio" id="speed-agree" name=""""),_display_(/*51.55*/{SurveyFormFields.speed}),format.raw/*51.79*/("""" value="4">
				"""),_display_(/*52.6*/Messages("survey.agree.response")),format.raw/*52.39*/("""
		    """),format.raw/*53.7*/("""</label>
		    <label class="block-label--stacked" for="speed-neutral">
		        <input type="radio" id="speed-neutral" name=""""),_display_(/*55.57*/{SurveyFormFields.speed}),format.raw/*55.81*/("""" value="3">
				"""),_display_(/*56.6*/Messages("survey.neutral.response")),format.raw/*56.41*/("""
		    """),format.raw/*57.7*/("""</label>
		    <label class="block-label--stacked" for="speed-disagree">
		        <input type="radio" id="speed-disagree" name=""""),_display_(/*59.58*/{SurveyFormFields.speed}),format.raw/*59.82*/("""" value="2">
				"""),_display_(/*60.6*/Messages("survey.disagree.response")),format.raw/*60.42*/("""
		    """),format.raw/*61.7*/("""</label>
		    <label class="block-label--stacked" for="speed-strongly-disagree">
		        <input type="radio" id="speed-strongly-disagree" name=""""),_display_(/*63.67*/{SurveyFormFields.speed}),format.raw/*63.91*/("""" value="1">
				"""),_display_(/*64.6*/Messages("survey.strongly.disagree.response")),format.raw/*64.51*/("""
		    """),format.raw/*65.7*/("""</label>
		</fieldset>

		<div class="form-field-group">
			<legend class="float--none" for="improve">"""),_display_(/*69.47*/Messages("survey.tell.us.how.we.can.improve")),format.raw/*69.92*/("""</legend>
		    <textarea maxlength="2500" id="improve" name=""""),_display_(/*70.54*/{SurveyFormFields.improve}),format.raw/*70.80*/("""" cols="40" rows="6"></textarea>
		    <p class="push--top"><small>"""),_display_(/*71.36*/Messages("survey.2500.characters.or.less")),format.raw/*71.78*/("""</small></p>
		</div>

		<button id="submit-survey-button" type="submit" class="button">"""),_display_(/*74.67*/Messages("survey.submit")),format.raw/*74.92*/("""</button>
		
	""")))}),format.raw/*76.3*/("""

""")))}))
      }
    }
  }

  def render(ticketId:String,serviceId:String,request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(ticketId,serviceId)(request,lang,messages)

  def f:((String,String) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (ticketId,serviceId) => (request,lang,messages) => apply(ticketId,serviceId)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object survey extends survey_Scope0.survey
              /*
                  -- GENERATED --
                  DATE: Mon Apr 10 13:51:25 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/survey.scala.html
                  HASH: afc73c9e5a6e7b49717472d0a2315e87f21f9866
                  MATRIX: 632->1|913->103|941->191|970->195|1050->267|1089->269|1119->272|1181->308|1226->332|1272->352|1354->425|1394->427|1431->437|1487->466|1516->474|1615->546|1645->555|1784->667|1851->713|2025->860|2072->886|2116->904|2179->946|2213->953|2368->1081|2415->1107|2459->1125|2513->1158|2547->1165|2706->1297|2753->1323|2797->1341|2853->1376|2887->1383|3048->1517|3095->1543|3139->1561|3196->1597|3230->1604|3409->1756|3456->1782|3500->1800|3566->1845|3600->1852|3724->1949|3793->1997|3963->2140|4008->2164|4052->2182|4115->2224|4149->2231|4300->2355|4345->2379|4389->2397|4443->2430|4477->2437|4632->2565|4677->2589|4721->2607|4777->2642|4811->2649|4968->2779|5013->2803|5057->2821|5114->2857|5148->2864|5323->3012|5368->3036|5412->3054|5478->3099|5512->3106|5642->3209|5708->3254|5798->3317|5845->3343|5940->3411|6003->3453|6119->3542|6165->3567|6210->3582
                  LINES: 22->1|28->1|30->5|33->8|33->8|33->8|35->10|36->11|36->11|39->14|39->14|39->14|41->16|41->16|41->16|42->17|42->17|46->21|46->21|48->23|48->23|49->24|49->24|50->25|52->27|52->27|53->28|53->28|54->29|56->31|56->31|57->32|57->32|58->33|60->35|60->35|61->36|61->36|62->37|64->39|64->39|65->40|65->40|66->41|70->45|70->45|72->47|72->47|73->48|73->48|74->49|76->51|76->51|77->52|77->52|78->53|80->55|80->55|81->56|81->56|82->57|84->59|84->59|85->60|85->60|86->61|88->63|88->63|89->64|89->64|90->65|94->69|94->69|95->70|95->70|96->71|96->71|99->74|99->74|101->76
                  -- GENERATED --
              */
          