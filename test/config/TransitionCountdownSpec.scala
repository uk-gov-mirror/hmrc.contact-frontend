/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package config

import java.time.ZonedDateTime

import helpers.MessagesSupport
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Configuration
import play.api.i18n.Messages
import play.api.mvc.RequestHeader
import play.api.test.FakeRequest

class TransitionCountdownSpec extends AnyWordSpec with Matchers with MessagesSupport with GuiceOneAppPerSuite {
  implicit lazy val fakeRequest: RequestHeader = FakeRequest("GET", "/foo")
  implicit lazy val messages: Messages         = getMessages(app, fakeRequest)
  val configuration: Configuration             = app.injector.instanceOf[Configuration]

  "daysLeft" should {
    "gives the days left until end of transition period when less than a day before transition" in {
      val currentDateHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T23:00:00Z[Europe/London]")
      }
      val countdownHelper   = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.daysLeftText should be("01")
    }

    "gives the days left until end of transition period when a whole day before transition" in {
      val currentDateHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T00:00:00Z[Europe/London]")
      }
      val countdownHelper   = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.daysLeftText should be("01")
    }
  }

  "show" should {
    "returns true until 23.59 on December 31st 2020" in {
      val currentDateHelper: CurrentTimeHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T23:59:00Z[Europe/London]")
      }
      val countdownHelper                      = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.show should be(true)
    }

    "returns false from midnight on the eve of January 1st 2021" in {
      val currentDateHelper: CurrentTimeHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2021-01-01T00:00:00Z[Europe/London]")
      }
      val countdownHelper                      = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.show should be(false)
    }

    "not pluralize day if not necessary" in {
      val currentDateHelper: CurrentTimeHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-31T00:00:00Z[Europe/London]")
      }
      val countdownHelper                      = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.daysText(messages) should be("day to go")
    }

    "pluralize day if necessary" in {
      val currentDateHelper: CurrentTimeHelper = new CurrentTimeHelper {
        override def getCurrentTime = ZonedDateTime.parse("2020-12-30T00:00:00Z[Europe/London]")
      }
      val countdownHelper                      = new TransitionHelper(currentDateHelper, configuration)

      countdownHelper.daysText(messages) should be("days to go")
    }
  }
}
