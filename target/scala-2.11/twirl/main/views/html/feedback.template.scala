
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object feedback_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class feedback extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Form[controllers.FeedbackForm],Option[uk.gov.hmrc.play.frontend.auth.AuthContext],Option[String],Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(feedbackForm: Form[controllers.FeedbackForm],
  user: Option[uk.gov.hmrc.play.frontend.auth.AuthContext],
  service: Option[String] = None)(implicit request : Request[_], lang : Lang, messages : Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import uk.gov.hmrc.play.views.html.helpers._

Seq[Any](format.raw/*3.99*/("""

"""),format.raw/*6.1*/("""
"""),_display_(/*7.2*/main(title = Messages("common.feedback.heading"), userLoggedIn = user.isDefined)/*7.82*/ {_display_(Seq[Any](format.raw/*7.84*/("""

    """),_display_(/*9.6*/defining(user.map{_ => routes.FeedbackController.submit}.getOrElse(routes.FeedbackController.submitUnauthenticated))/*9.122*/  { call =>_display_(Seq[Any](format.raw/*9.133*/("""
        """),_display_(/*10.10*/views/*10.15*/.html.partials.feedback_form(feedbackForm, call.url, service)),format.raw/*10.76*/("""
    """)))}),format.raw/*11.6*/("""

""")))}))
      }
    }
  }

  def render(feedbackForm:Form[controllers.FeedbackForm],user:Option[uk.gov.hmrc.play.frontend.auth.AuthContext],service:Option[String],request:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},lang:Lang,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(feedbackForm,user,service)(request,lang,messages)

  def f:((Form[controllers.FeedbackForm],Option[uk.gov.hmrc.play.frontend.auth.AuthContext],Option[String]) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Lang,Messages) => play.twirl.api.HtmlFormat.Appendable) = (feedbackForm,user,service) => (request,lang,messages) => apply(feedbackForm,user,service)(request,lang,messages)

  def ref: this.type = this

}


}

/**/
object feedback extends feedback_Scope0.feedback
              /*
                  -- GENERATED --
                  DATE: Thu Mar 30 11:37:41 BST 2017
                  SOURCE: /home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/app/views/feedback.scala.html
                  HASH: fd065b0819b3ca2eb3cafe9a88c96a545d129c1d
                  MATRIX: 719->1|1063->206|1091->254|1118->256|1206->336|1245->338|1277->345|1402->461|1451->472|1488->482|1502->487|1584->548|1620->554
                  LINES: 22->1|29->3|31->6|32->7|32->7|32->7|34->9|34->9|34->9|35->10|35->10|35->10|36->11
                  -- GENERATED --
              */
          