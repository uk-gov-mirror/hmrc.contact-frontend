package support.page

import support.modules.SharedPageModules
import support.steps.Env

class ContactHmrcPage extends WebPage with SharedPageModules {

  override val url = Env.host + "/contact-hmrc"

  def nameField = textField("contact-name")
  def emailField = textField("contact-email")
  def commentsField = textArea("contact-comments")
  def submitBtn = cssSelector("button[type=submit]")

  def sendContactForm(name: String, email: String, comment: String) = {
    nameField.value = name
    emailField.value = email
    commentsField.value = comment

    click on submitBtn
  }
}