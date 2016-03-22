
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amrelmasry/Work/Projects/play_framework/Actors Design/conf/routes
// @DATE:Mon Mar 21 16:02:02 EET 2016


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
