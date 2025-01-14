/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package config

import javax.inject.Inject
import play.api.Configuration

trait AppConfig {

  def contactHmrcAboutTaxUrl: String
  def externalReportProblemUrl: String
  def externalReportProblemSecureUrl: String
  def backUrlDestinationAllowList: Set[String]
  def loginCallback(continueUrl: String): String
  def enableLanguageSwitching: Boolean

}

class CFConfig @Inject() (configuration: Configuration) extends AppConfig {

  private def loadConfigString(key: String): String =
    configuration
      .getOptional[String](key)
      .getOrElse(configNotFoundError(key))

  private val contactHost = configuration
    .getOptional[String]("contact-frontend.host")
    .getOrElse("")

  override def contactHmrcAboutTaxUrl: String =
    loadConfigString("contactHmrcAboutTax.url")

  override lazy val externalReportProblemUrl =
    s"$contactHost/contact/problem_reports"

  override lazy val externalReportProblemSecureUrl =
    s"$contactHost/contact/problem_reports_secure"

  override lazy val backUrlDestinationAllowList =
    loadConfigString("backUrlDestinationAllowList")
      .split(',')
      .filter(_.nonEmpty)
      .toSet

  override def loginCallback(continueUrl: String) = s"$contactHost$continueUrl"

  override def enableLanguageSwitching =
    configuration
      .getOptional[Boolean]("enableLanguageSwitching")
      .getOrElse(false)

  private def configNotFoundError(key: String) =
    throw new RuntimeException(s"Could not find config key '$key'")

}
