/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package config

import java.time.temporal.ChronoUnit
import java.time.{Duration, ZoneId, ZonedDateTime}

import javax.inject.Inject
import play.api.Configuration
import play.api.i18n.Messages

class TransitionHelper @Inject() (currentDateHelper: CurrentTimeHelper, config: Configuration) {
  private val endOfTransitionPeriod: ZonedDateTime =
    config.getOptional[String]("transition.endOfTransitionPeriod").map(ZonedDateTime.parse(_)).get

  def daysLeftText: String = "%02d".format(daysLeft)

  def show: Boolean =
    daysLeft > 0 && daysLeft < 100

  def daysText(implicit messages: Messages): String =
    if (daysLeft == 1) {
      messages("transition.countdown.day_to_go")
    } else {
      messages("transition.countdown.days_to_go")
    }

  private def daysLeft: Int =
    Duration
      .between(currentDateHelper.getCurrentTime.truncatedTo(ChronoUnit.DAYS), endOfTransitionPeriod)
      .toDays
      .toInt
}

class CurrentTimeHelper {
  def getCurrentTime: ZonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/London"))
}
