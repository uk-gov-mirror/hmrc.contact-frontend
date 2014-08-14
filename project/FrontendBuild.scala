import sbt._

object FrontendBuild extends Build with MicroService {
  import scala.util.Properties.envOrElse

  val appName = "contact-frontend"
  val appVersion = envOrElse("CONTACT_FRONTEND_VERSION", "999-SNAPSHOT")

  override lazy val appDependencies: Seq[ModuleID] = AppDependencies()
}

private object AppDependencies {
  import play.PlayImport._
  import play.core.PlayVersion

  private val playMicroServiceVersion = "3.0.0" //"2.0.0"
  private val playHealthVersion = "0.4.0" //"0.2.0"    

  private val playFrontendVersion =  "6.5.0" //"5.5.1"
  private val govukTemplateVersion =  "2.0.1" //"1.7.0"
  
  private val scalatestVersion = "2.2.0"
  private val pegdownVersion = "1.4.2"

  val compile = Seq(
    ws,
    "uk.gov.hmrc" %% "play-microservice" % playMicroServiceVersion,
    "uk.gov.hmrc" %% "play-health" % playHealthVersion,
    "uk.gov.hmrc" %% "play-frontend" % playFrontendVersion,
    "uk.gov.hmrc" %% "govuk-template" % govukTemplateVersion,

    "com.kenshoo" %% "metrics-play" % "2.3.0_0.1.6",
    "com.codahale.metrics" % "metrics-graphite" % "3.0.1",
    "org.apache.httpcomponents" % "httpclient" % "4.3.1"
  )

  trait TestDependencies {
    lazy val scope: String = "test"
    lazy val test : Seq[ModuleID] = ???
  }

  object Test {
    def apply() = new TestDependencies {
      override lazy val test = Seq(
        "uk.gov.hmrc" %% "play-microservice" % playMicroServiceVersion % scope classifier "tests",
        "uk.gov.hmrc" %% "play-frontend" % playFrontendVersion % scope classifier "tests",
        "org.scalatest" %% "scalatest" % "2.2.0" % scope,
        "org.pegdown" % "pegdown" % "1.4.2" % scope,
        "org.jsoup" % "jsoup" % "1.7.2" % scope,
        "com.typesafe.play" %% "play-test" % PlayVersion.current % scope,

        "com.github.tomakehurst" % "wiremock" % "1.46" % "test",
        "org.seleniumhq.selenium" % "selenium-java" % "2.41.0" % "test",
        "uk.gov.hmrc" %% "scala-webdriver" % "4.0.0" % "test"
      )
    }.test
  }

  def apply() = compile ++ Test()
}

