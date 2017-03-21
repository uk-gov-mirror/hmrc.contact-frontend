package unit.util

import play.api.Environment
import play.api.i18n.{DefaultLangs, DefaultMessagesApi, Lang}
import play.api.test.FakeApplication
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class MessagesSpec extends UnitSpec with WithFakeApplication {

  override lazy val fakeApplication = new FakeApplication(
    additionalConfiguration = Map("application.langs" -> "en,cy",
      "govuk-tax.Test.enableLanguageSwitching" -> true)
  )

  val messagesAPI = new DefaultMessagesApi(Environment.simple(), fakeApplication.configuration, new DefaultLangs(fakeApplication.configuration))
  val languageEnglish = Lang.get("en").getOrElse(throw new Exception())
  val languageWelsh = Lang.get("cy").getOrElse(throw new Exception())
  val MatchSingleQuoteOnly = """\w+'{1}\w+""".r
  val MatchBacktickQuoteOnly = """`+""".r
  val MatchForwardTickQuoteOnly = """’+""".r

  "Application" should {
    "have the correct message configs" in {
      messagesAPI.messages.size shouldBe 4
      messagesAPI.messages.keys should contain theSameElementsAs Vector("en", "cy", "default", "default.play")
    }

    "have messages for default and cy only" in {
      messagesAPI.messages("en").size shouldBe 0
      val englishMessageCount = messagesAPI.messages("default").size - frameworkProvidedKeys.size
      messagesAPI.messages("cy").size shouldBe englishMessageCount
      messagesAPI.messages("default.play").size shouldBe 46
    }
  }

  "All message files" should {
    "have the same set of keys" in {
      withClue(describeMismatch(defaultMessages.keySet, welshMessages.keySet)) {
        welshMessages.keySet shouldBe defaultMessages.keySet
      }
    }
    "have a non-empty message for each key" in {
      assertNonEmptyValuesForDefaultMessages()
      assertNonEmptyValuesForWelshMessages()
    }
    "have no unescaped single quotes in value" in {
      assertCorrectUseOfQuotesForDefaultMessages()
      assertCorrectUseOfQuotesForWelshMessages()
    }
    "have a resolvable message for keys which take args" in {
      countMessagesWithArgs(welshMessages).size shouldBe countMessagesWithArgs(defaultMessages).size
    }
  }

  private def countMessagesWithArgs(messages: Map[String, String]) = messages.values.filter(_.contains("{0"))

  private def assertNonEmptyValuesForDefaultMessages() = assertNonEmptyNonTemporaryValues("Default", defaultMessages)

  private def assertNonEmptyValuesForWelshMessages() = assertNonEmptyNonTemporaryValues("Welsh", welshMessages)

  private def assertCorrectUseOfQuotesForDefaultMessages() = assertCorrectUseOfQuotes("Default", defaultMessages)

  private def assertCorrectUseOfQuotesForWelshMessages() = assertCorrectUseOfQuotes("Welsh", welshMessages)

  private def assertNonEmptyNonTemporaryValues(label: String, messages: Map[String, String]) = messages.foreach { case (key: String, value: String) =>
    withClue(s"In $label, there is an empty value for the key:[$key][$value]") {
      value.trim.isEmpty shouldBe false
    }
  }

  private def assertCorrectUseOfQuotes(label: String, messages: Map[String, String]) = messages.foreach { case (key: String, value: String) =>
    withClue(s"In $label, there is an unescaped or invalid quote:[$key][$value]") {
      MatchSingleQuoteOnly.findFirstIn(value).isDefined shouldBe false
      MatchBacktickQuoteOnly.findFirstIn(value).isDefined shouldBe false
      MatchForwardTickQuoteOnly.findFirstIn(value).isDefined shouldBe false
    }
  }

  private def listMissingMessageKeys(header: String, missingKeys: Set[String]) = missingKeys.toList.sorted.mkString(header + displayLine, "\n", displayLine)

  private lazy val displayLine = "\n" + ("@" * 42) + "\n"

  private lazy val defaultMessages = getExpectedMessages("default") -- providedKeys

  private lazy val welshMessages = getExpectedMessages("cy") -- commonProvidedKeys

  private def getExpectedMessages(languageCode: String) = messagesAPI.messages.getOrElse(languageCode, throw new Exception(s"Missing messages for $languageCode"))

  private def describeMismatch(defaultKeySet: Set[String], welshKeySet: Set[String]) =
    if (defaultKeySet.size > welshKeySet.size) listMissingMessageKeys("The following message keys are missing from the Welsh Set:", defaultKeySet -- welshKeySet)
    else listMissingMessageKeys("The following message keys are missing from the Default Set:", welshKeySet -- defaultKeySet)


  private val commonProvidedKeys = Set(
    "error.address.invalid.character")

  private val frameworkProvidedKeys = Set(
    "global.error.InternalServerError500.heading",
    "global.error.InternalServerError500.message",
    "global.error.InternalServerError500.title",
    "global.error.badRequest400.heading",
    "global.error.badRequest400.message",
    "global.error.badRequest400.title",
    "global.error.pageNotFound404.heading",
    "global.error.pageNotFound404.message",
    "global.error.pageNotFound404.title"
  )

  private val providedKeys = commonProvidedKeys ++ frameworkProvidedKeys
}