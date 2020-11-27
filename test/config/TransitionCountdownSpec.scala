/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package config

import java.util.{Calendar, GregorianCalendar}

import helpers.MessagesSupport
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.i18n.Messages
import play.api.mvc.RequestHeader
import play.api.test.FakeRequest

class TransitionCountdownSpec extends AnyWordSpec with Matchers with MessagesSupport with GuiceOneAppPerSuite {
  implicit lazy val fakeRequest: RequestHeader = FakeRequest("GET", "/foo")
  implicit lazy val messages: Messages         = getMessages(app, fakeRequest)

  "daysLeft" should {
    "gives the days left until end of transition period when less than a day before transition" in {
      val currentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 0, 0)
      }
      val countdownHelper   = new CountdownHelper(currentDateHelper)

      countdownHelper.daysLeftText should be("01")
    }

    "gives the days left until end of transition period when a whole day before transition" in {
      val currentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 0, 0, 0)
      }
      val countdownHelper   = new CountdownHelper(currentDateHelper)

      countdownHelper.daysLeftText should be("01")
    }
  }

  "show" should {
    "returns true until 23.59 on December 31st 2020" in {
      val currentDateHelper: CurrentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 0)
      }
      val countdownHelper                      = new CountdownHelper(currentDateHelper)

      countdownHelper.show should be(true)
    }

    "returns false from midnight on the eve of January 1st 2021" in {
      val currentDateHelper: CurrentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2021, Calendar.JANUARY, 1, 0, 0)
      }
      val countdownHelper                      = new CountdownHelper(currentDateHelper)

      countdownHelper.show should be(false)
    }

    "not pluralize day if not necessary" in {
      val currentDateHelper: CurrentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 0, 0)
      }
      val countdownHelper                      = new CountdownHelper(currentDateHelper)

      countdownHelper.daysText(messages) should be("day to go")
    }

    "pluralize day if necessary" in {
      val currentDateHelper: CurrentDateHelper = new CurrentDateHelper {
        override def getCurrentDate = new GregorianCalendar(2020, Calendar.DECEMBER, 30, 0, 0)
      }
      val countdownHelper                      = new CountdownHelper(currentDateHelper)

      countdownHelper.daysText(messages) should be("days to go")
    }
  }
}
