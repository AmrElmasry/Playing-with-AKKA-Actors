
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amrelmasry/Work/Projects/play_framework/Actors Design/conf/routes
// @DATE:Mon Mar 21 16:02:02 EET 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def createProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.createProject",
      """
        function(projectName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "create_project" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("projectName", projectName)])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:11
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.test",
      """
        function(ProjectId,UserId,name) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("ProjectId", ProjectId) + "/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("UserId", encodeURIComponent(UserId)) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
        }
      """
    )
  
  }


}