
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/amit/Documents/ChangeSET/learnJavaAngularJs_DesignPatterns/conf/routes
// @DATE:Mon Jul 02 18:26:19 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:14
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:14
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getChartData""", """controllers.HomeController.getChartData"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """setChartData""", """controllers.HomeController.setChartData"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """filterChart""", """controllers.HomeController.filterChart"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isIpUnique""", """controllers.HomeController.isIpUnique"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rawData""", """controllers.HomeController.rawData"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_getChartData1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getChartData")))
  )
  private[this] lazy val controllers_HomeController_getChartData1_invoker = createInvoker(
    HomeController_0.getChartData,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getChartData",
      Nil,
      "GET",
      """""",
      this.prefix + """getChartData"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_setChartData2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("setChartData")))
  )
  private[this] lazy val controllers_HomeController_setChartData2_invoker = createInvoker(
    HomeController_0.setChartData,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "setChartData",
      Nil,
      "POST",
      """""",
      this.prefix + """setChartData"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_filterChart3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("filterChart")))
  )
  private[this] lazy val controllers_HomeController_filterChart3_invoker = createInvoker(
    HomeController_0.filterChart,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "filterChart",
      Nil,
      "POST",
      """""",
      this.prefix + """filterChart"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_isIpUnique4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isIpUnique")))
  )
  private[this] lazy val controllers_HomeController_isIpUnique4_invoker = createInvoker(
    HomeController_0.isIpUnique,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isIpUnique",
      Nil,
      "POST",
      """""",
      this.prefix + """isIpUnique"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_rawData5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rawData")))
  )
  private[this] lazy val controllers_HomeController_rawData5_invoker = createInvoker(
    HomeController_0.rawData,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "rawData",
      Nil,
      "GET",
      """""",
      this.prefix + """rawData"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_HomeController_getChartData1_route(params) =>
      call { 
        controllers_HomeController_getChartData1_invoker.call(HomeController_0.getChartData)
      }
  
    // @LINE:8
    case controllers_HomeController_setChartData2_route(params) =>
      call { 
        controllers_HomeController_setChartData2_invoker.call(HomeController_0.setChartData)
      }
  
    // @LINE:9
    case controllers_HomeController_filterChart3_route(params) =>
      call { 
        controllers_HomeController_filterChart3_invoker.call(HomeController_0.filterChart)
      }
  
    // @LINE:10
    case controllers_HomeController_isIpUnique4_route(params) =>
      call { 
        controllers_HomeController_isIpUnique4_invoker.call(HomeController_0.isIpUnique)
      }
  
    // @LINE:11
    case controllers_HomeController_rawData5_route(params) =>
      call { 
        controllers_HomeController_rawData5_invoker.call(HomeController_0.rawData)
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
