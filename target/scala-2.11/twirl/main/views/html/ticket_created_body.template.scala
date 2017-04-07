
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ticket_created_body_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class ticket_created_body extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Option[String],Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticketId: String, thankYouMessage: Option[String])(implicit lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.96*/("""

"""),format.raw/*3.1*/("""<h2 id="feedback-thank-you-header">"""),_display_(/*3.37*/Messages("common.thank.you")),format.raw/*3.65*/("""</h2>

<input id="ticketId" type="hidden" value=""""),_display_(/*5.44*/ticketId),format.raw/*5.52*/(""""/>
<p>"""),_display_(/*6.5*/Html(Messages(thankYouMessage.getOrElse("contact.confirmation.message")))),format.raw/*6.78*/("""</p>"""))
      }
    }
  }

  def render(ticketId:String,thankYouMessage:Option[String],lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(ticketId,thankYouMessage)(lang,messages)

  def f:((String,Option[String]) => (Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (ticketId,thankYouMessage) => (lang,messages) => apply(ticketId,thankYouMessage)(lang,messages)

  def ref: this.type = this

}


}

/**/
object ticket_created_body extends ticket_created_body_Scope0.ticket_created_body
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:42 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/ticket_created_body.scala.html
                  HASH: c85e1ff07d5210130b283493e12ed9060e3f09b6
                  MATRIX: 584->1|773->95|801->97|863->133|911->161|987->211|1015->219|1048->227|1141->300
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|29->5|30->6|30->6
                  -- GENERATED --
              */
          