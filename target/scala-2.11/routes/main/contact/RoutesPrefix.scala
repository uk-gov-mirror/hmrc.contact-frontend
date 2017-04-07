
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sam/Applications/hmrc-development-environment/hmrc/ddct/bta/contact-frontend/conf/contact.routes
// @DATE:Thu Mar 30 11:37:41 BST 2017


package contact {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
