
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amit/Documents/ChangeSET/learnJavaAngularJs_DesignPatterns/conf/routes
// @DATE:Mon Jul 02 18:26:19 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
