/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package views.partials

import java.time.ZonedDateTime

import _root_.helpers.{JsoupHelpers, MessagesSupport}
import config.{AppConfig, CurrentTimeHelper, TransitionHelper}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.{Application, Configuration}
import play.api.i18n.Messages
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.RequestHeader
import play.api.test.FakeRequest
import views.html.partials.TransitionCountdown

class TransitionCountdownSpec
    extends AnyWordSpec
    with Matchers
    with GuiceOneAppPerSuite
    with MessagesSupport
    with JsoupHelpers {

  override def fakeApplication(): Application =
    new GuiceApplicationBuilder()
      .configure(
        "metrics.jvm"     -> false,
        "metrics.enabled" -> false
      )
      .build()

  implicit lazy val fakeRequest: RequestHeader = FakeRequest("GET", "/foo")
  implicit lazy val messages: Messages         = getMessages(app, fakeRequest)
  implicit lazy val appConfig: AppConfig       = app.injector.instanceOf[AppConfig]
  val configuration: Configuration             = app.injector.instanceOf[Configuration]

  "the transition countdown component" should {
    "renders the countdown with single digits correctly" in {
      val currentDateHelper                 = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T23:00:00Z[Europe/London]")
      }
      val countdownHelper: TransitionHelper = new TransitionHelper(currentDateHelper, configuration)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".hmrc-transition-countdown")                 should have size 1
      content.select(".hmrc-transition-countdown__countdown").text should be("01 day to go")
    }

    "renders the countdown with double digits correctly" in {
      val currentDateHelper                 = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-21T23:00:00Z[Europe/London]")
      }
      val countdownHelper: TransitionHelper = new TransitionHelper(currentDateHelper, configuration)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".hmrc-transition-countdown")                 should have size 1
      content.select(".hmrc-transition-countdown__countdown").text should be("11 days to go")
    }

    "renders the call to action with title, countdown, and content" in {
      val currentDateHelper                 = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T23:00:00Z[Europe/London]")
      }
      val countdownHelper: TransitionHelper = new TransitionHelper(currentDateHelper, configuration)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".hmrc-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".hmrc-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".hmrc-transition-countdown__countdown").first.text                 should be("01 day to go")
      content.select(".hmrc-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }

    "not render the countdown after transition" in {
      val currentDateHelper                 = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2021-01-01T09:00:00Z[Europe/London]")
      }
      val countdownHelper: TransitionHelper = new TransitionHelper(currentDateHelper, configuration)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".hmrc-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".hmrc-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".hmrc-transition-countdown__countdown")                            should have size 0
      content.select(".hmrc-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }

    "not render the countdown if number of days is more than 2 digits" in {
      val currentDateHelper                 = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-09-23T09:00:00Z[Europe/London]")
      }
      val countdownHelper: TransitionHelper = new TransitionHelper(currentDateHelper, configuration)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".hmrc-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".hmrc-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".hmrc-transition-countdown__countdown")                            should have size 0
      content.select(".hmrc-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }
  }
}
