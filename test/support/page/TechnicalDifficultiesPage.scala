package support.page

import support.modules.SharedPageModules
import support.steps.Env

object TechnicalDifficultiesPage  extends WebPage with SharedPageModules {
  override val url = Env.host + "/contact/???"

  override def isCurrentPage: Boolean = heading=="Sorry, we're experiencing technical difficulties"
}
