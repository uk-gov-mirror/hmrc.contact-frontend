import sbt.Keys._
import sbt.Tests.{SubProcess, Group}
import sbt._

trait MicroService {

  import uk.gov.hmrc._
  import DefaultBuildSettings._
  import uk.gov.hmrc.{SbtBuildInfo, ShellPrompt}

  import TestPhases._

  val appName: String
  val appVersion: String

  lazy val appDependencies : Seq[ModuleID] = ???
  lazy val plugins : Seq[Plugins] = Seq(play.PlayScala)
  lazy val playSettings : Seq[Setting[_]] = Seq.empty

  def unitFilter(name: String): Boolean = !funFilter(name) && !smokeFilter(name)
  def funFilter(name: String): Boolean = name endsWith "Feature"
  def smokeFilter(name: String): Boolean = name endsWith "SmokeTest"

  lazy val microservice = Project(appName, file("."))
    .enablePlugins(plugins : _*)
    .settings(playSettings : _*)
    .settings(version := appVersion)
    .settings(scalaSettings: _*)
    .settings(defaultSettings(): _*)
    .settings(
      targetJvm := "jvm-1.7",
      shellPrompt := ShellPrompt(appVersion),
      libraryDependencies ++= appDependencies,
      parallelExecution in Test := false,
      fork in Test := false,
      retrieveManaged := true
    )
    .settings(Repositories.playPublishingSettings : _*)
    .settings(inConfig(TemplateTest)(Defaults.testSettings): _*)
    .settings(testOptions in Test := Seq(Tests.Filter(unitFilter)))
    .configs(IntegrationTest)
    .settings(inConfig(TemplateItTest)(Defaults.itSettings): _*)
    .settings(
      Keys.fork in IntegrationTest := false,
      unmanagedSourceDirectories in IntegrationTest <<= (baseDirectory in IntegrationTest)(base => Seq(base / "it")),
      addTestReportOption(IntegrationTest, "int-test-reports"),
      testGrouping in IntegrationTest := oneForkedJvmPerTest((definedTests in IntegrationTest).value),
      parallelExecution in IntegrationTest := false)
    .settings(SbtBuildInfo(): _*)
    .configs(FunTest)
    .settings(inConfig(FunTest)(Defaults.testSettings): _*)
    .settings(
      testOptions in FunTest := Seq(Tests.Filter(funFilter)),
      unmanagedSourceDirectories   in FunTest <<= (baseDirectory in FunTest)(base => Seq(base / "test")),
      unmanagedResourceDirectories in FunTest <<= (baseDirectory in FunTest)(base => Seq(base / "test")),
      Keys.fork in FunTest := false,
      parallelExecution in FunTest := false,
      addTestReportOption(FunTest, "fun-test-reports")
    )
    .configs(SmokeTest)
    .settings(inConfig(SmokeTest)(Defaults.testSettings): _*)
    .settings(
      javaOptions in SmokeTest := Seq("-Denvironment=qa"),
      testOptions in SmokeTest := Seq(Tests.Filter(smokeFilter)),
      unmanagedSourceDirectories   in SmokeTest <<= (baseDirectory in SmokeTest)(base => Seq(base / "test")),
      unmanagedResourceDirectories in SmokeTest <<= (baseDirectory in SmokeTest)(base => Seq(base / "test")),
      Keys.fork in SmokeTest := true,
      parallelExecution in SmokeTest := false,
      addTestReportOption(SmokeTest, "smoke-test-reports")
    )
}

private object TestPhases {

  val allPhases = "tt->test;test->test;test->compile;compile->compile"
  val allItPhases = "tit->it;it->it;it->compile;compile->compile"

  lazy val TemplateTest = config("tt") extend Test
  lazy val TemplateItTest = config("tit") extend IntegrationTest
  lazy val FunTest = config("fun") extend Test
  lazy val SmokeTest = config("smoke") extend Test

  def oneForkedJvmPerTest(tests: Seq[TestDefinition]) =
    tests map {
      test => new Group(test.name, Seq(test), SubProcess(ForkOptions(runJVMOptions = Seq("-Dtest.name=" + test.name))))
    }
}

private object Repositories {

  import uk.gov.hmrc._
  import PublishingSettings._
  import NexusPublishing._

  lazy val dist = com.typesafe.sbt.SbtNativePackager.NativePackagerKeys.dist

  val publishDist = TaskKey[sbt.File]("publish-dist", "publish the dist artifact")

  lazy val playPublishingSettings : Seq[sbt.Setting[_]] = sbtrelease.ReleasePlugin.releaseSettings ++ Seq(

    credentials += SbtCredentials,

    publishArtifact in(Compile, packageDoc) := false,
    publishArtifact in(Compile, packageSrc) := false,
    publishArtifact in(Compile, packageBin) := true,

    artifact in publishDist ~= {
      (art: Artifact) => art.copy(`type` = "zip", extension = "zip")
    },

    publishDist <<= (target, normalizedName, version) map {
      (targetDir, id, version) =>
        val packageName = "%s-%s" format(id, version)
        targetDir / "universal" / (packageName + ".zip")
    },

    publishLocal <<= publishLocal dependsOn dist

  ) ++
    publishAllArtefacts ++
    nexusPublishingSettings ++
    addArtifact(artifact in publishDist, publishDist)

}