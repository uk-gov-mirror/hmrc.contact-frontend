/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package views.partials

import java.util.{Calendar, GregorianCalendar}

import _root_.helpers.{JsoupHelpers, MessagesSupport}
import config.{AppConfig, CountdownHelper, CurrentDateHelper}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Application
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

  "the transition countdown component" should {
    "renders the countdown with single digits correctly" in {
      val currentDateHelper                = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 0, 0)
      }
      val countdownHelper: CountdownHelper = new CountdownHelper(currentDateHelper)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".gem-c-transition-countdown")                 should have size 1
      content.select(".gem-c-transition-countdown__countdown").text should be("01 day to go")
    }

    "renders the countdown with double digits correctly" in {
      val currentDateHelper                = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 21, 23, 0, 0)
      }
      val countdownHelper: CountdownHelper = new CountdownHelper(currentDateHelper)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".gem-c-transition-countdown")                 should have size 1
      content.select(".gem-c-transition-countdown__countdown").text should be("11 days to go")
    }

    "renders the call to action with title, countdown, and content" in {
      val currentDateHelper                = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 0, 0)
      }
      val countdownHelper: CountdownHelper = new CountdownHelper(currentDateHelper)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".gem-c-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".gem-c-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".gem-c-transition-countdown__countdown").first.text                 should be("01 day to go")
      content.select(".gem-c-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }

    "not render the countdown after transition" in {
      val currentDateHelper                = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2021, Calendar.JANUARY, 1, 9, 0, 0)
      }
      val countdownHelper: CountdownHelper = new CountdownHelper(currentDateHelper)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".gem-c-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".gem-c-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".gem-c-transition-countdown__countdown")                            should have size 0
      content.select(".gem-c-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }

    "not render the countdown if number of days is more than 2 digits" in {
      val currentDateHelper                = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.SEPTEMBER, 23, 9, 0, 0)
      }
      val countdownHelper: CountdownHelper = new CountdownHelper(currentDateHelper)

      val transitionCountdown: TransitionCountdown = new TransitionCountdown(countdownHelper)

      val content = transitionCountdown()

      content.select(".gem-c-transition-countdown[href='https://www.gov.uk/transition']") should have size 1
      content.select(".gem-c-transition-countdown__title").first.text                     should be("Brexit transition")
      content.select(".gem-c-transition-countdown__countdown")                            should have size 0
      content.select(".gem-c-transition-countdown__text").first.text                      should be("Check you’re ready for 2021")
    }
  }
}
