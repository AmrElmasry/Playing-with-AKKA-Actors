
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amrelmasry/Work/Projects/play_framework/Actors Design/conf/routes
// @DATE:Mon Mar 21 16:02:02 EET 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def createProject(projectName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "create_project" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("projectName", projectName)))))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:11
    def test(ProjectId:Int, UserId:String, name:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Int]].unbind("ProjectId", ProjectId) + "/users/" + implicitly[PathBindable[String]].unbind("UserId", dynamicString(UserId)) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
    }
  
  }


}