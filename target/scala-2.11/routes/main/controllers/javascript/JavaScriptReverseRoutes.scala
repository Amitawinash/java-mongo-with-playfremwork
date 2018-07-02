
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amit/Documents/ChangeSET/learnJavaAngularJs_DesignPatterns/conf/routes
// @DATE:Mon Jul 02 18:26:19 IST 2018

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def isIpUnique: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isIpUnique",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "isIpUnique"})
        }
      """
    )
  
    // @LINE:7
    def getChartData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getChartData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getChartData"})
        }
      """
    )
  
    // @LINE:11
    def rawData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.rawData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rawData"})
        }
      """
    )
  
    // @LINE:9
    def filterChart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.filterChart",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "filterChart"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:8
    def setChartData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.setChartData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "setChartData"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
