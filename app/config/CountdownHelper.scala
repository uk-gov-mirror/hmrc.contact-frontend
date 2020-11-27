/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package config

import java.time.{Duration, Instant}
import java.util.{Calendar, GregorianCalendar, TimeZone}

import javax.inject.Inject
import play.api.i18n.Messages

class CountdownHelper @Inject() (currentDateHelper: CurrentDateHelper) {
  val endOfTransitionPeriod = new GregorianCalendar(2021, Calendar.JANUARY, 1)

  def daysLeftText: String = "%02d".format(daysLeft)

  def show: Boolean =
    daysLeft > 0 && daysLeft < 100

  def daysText(implicit messages: Messages): String =
    if (daysLeft == 1) {
      messages("transition_countdown.day_to_go")
    } else {
      messages("transition_countdown.days_to_go")
    }

  private def daysLeft: Int =
    Duration
      .between(midnightOfCurrentDay, endOfTransitionPeriod.toInstant)
      .toDays
      .toInt

  private def midnightOfCurrentDay: Instant = {
    val currentDate = currentDateHelper.getCurrentDate
    val asMidnight  = new GregorianCalendar(
      currentDate.get(Calendar.YEAR),
      currentDate.get(Calendar.MONTH),
      currentDate.get(Calendar.DAY_OF_MONTH),
      0,
      0,
      0
    )
    asMidnight.toInstant
  }
}

class CurrentDateHelper {
  def getCurrentDate: Calendar = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"))
}
