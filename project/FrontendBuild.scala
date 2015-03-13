import sbt._

object FrontendBuild extends Build with MicroService {
  import scala.util.Properties.envOrElse

  val appName = "contact-frontend"
  val appVersion = envOrElse("CONTACT_FRONTEND_VERSION", "999-SNAPSHOT")

  override lazy val appDependencies: Seq[ModuleID] = AppDependencies()
}

private object AppDependencies {

  private val playHealthVersion = "0.7.0"
  private val playFrontendVersion =  "15.1.0"
  private val playUiVersion = "1.5.0"
  private val govUkTemplateVersion =  "2.1.0"

  private val scalatestVersion = "2.2.0"
  private val pegdownVersion = "1.4.2"

  val compile = Seq(
    "uk.gov.hmrc" %% "play-health" % playHealthVersion,
    "uk.gov.hmrc" %% "play-frontend" % playFrontendVersion,
    "uk.gov.hmrc" %% "play-ui" % playUiVersion,
    "uk.gov.hmrc" %% "govuk-template" % govUkTemplateVersion,
    "uk.gov.hmrc" %% "url-builder" % "0.3.0"
  )

  trait TestDependencies {
    lazy val scope: String = "test"
    lazy val test : Seq[ModuleID] = ???
  }

  object Test {
    def apply() = new TestDependencies {
      override lazy val test = Seq(
        "uk.gov.hmrc" %% "play-frontend" % playFrontendVersion % scope classifier "tests",
        "org.scalatest" %% "scalatest" % "2.2.2" % scope,
        "org.pegdown" % "pegdown" % "1.4.2" % scope,
        "org.jsoup" % "jsoup" % "1.7.3" % scope,

        "com.github.tomakehurst" % "wiremock" % "1.48" % "test",
        "uk.gov.hmrc" %% "scala-webdriver" % "4.18.0" % "test",
        "uk.gov.hmrc" %% "hmrctest" % "0.3.0" % "test"
      )
    }.test
  }

  def apply() = compile ++ Test()
}


