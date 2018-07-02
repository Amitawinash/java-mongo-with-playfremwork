
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Integer,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template takes a single argument, a String containing a
 * page_view to display.
 */
  def apply/*5.2*/(page_view: Integer):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.22*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html ng-app="landingPage" lang="en-US">

  <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="theme-color" content="#000"/>
   <title>Charts World</title>

    <script src=""""),_display_(/*15.19*/routes/*15.25*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.66*/(""""></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js" data-semver="1.6.1"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">
    <script src=""""),_display_(/*29.19*/routes/*29.25*/.Assets.versioned("javascripts/hello.js")),format.raw/*29.66*/(""""></script>
    <style>
      .horizontal-collapse """),format.raw/*31.28*/("""{"""),format.raw/*31.29*/("""
          """),format.raw/*32.11*/("""height: 70px;
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
      """),format.raw/*34.7*/(""".navbar-collapse.in """),format.raw/*34.27*/("""{"""),format.raw/*34.28*/("""
          """),format.raw/*35.11*/("""overflow-y: hidden;
      """),format.raw/*36.7*/("""}"""),format.raw/*36.8*/("""
      """),format.raw/*37.7*/(""".btn span.glyphicon """),format.raw/*37.27*/("""{"""),format.raw/*37.28*/("""
          """),format.raw/*38.11*/("""opacity: 0;
      """),format.raw/*39.7*/("""}"""),format.raw/*39.8*/("""
      """),format.raw/*40.7*/(""".btn.active span.glyphicon """),format.raw/*40.34*/("""{"""),format.raw/*40.35*/("""
          """),format.raw/*41.11*/("""opacity: 1;
      """),format.raw/*42.7*/("""}"""),format.raw/*42.8*/("""
      """),format.raw/*43.7*/(""".jumbotron"""),format.raw/*43.17*/("""{"""),format.raw/*43.18*/("""
          """),format.raw/*44.11*/("""padding-top: 0%;
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/("""
      """),format.raw/*46.7*/(""".cursor_pointer"""),format.raw/*46.22*/("""{"""),format.raw/*46.23*/("""
        """),format.raw/*47.9*/("""cursor: pointer;
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/("""
      """),format.raw/*49.7*/("""#nu_add_data_icon.svg-inline--fa.fa-w-14 """),format.raw/*49.48*/("""{"""),format.raw/*49.49*/("""
          """),format.raw/*50.11*/("""width: 1.875em;
      """),format.raw/*51.7*/("""}"""),format.raw/*51.8*/("""
      """),format.raw/*52.7*/("""#visualization_wrap """),format.raw/*52.27*/("""{"""),format.raw/*52.28*/("""
          """),format.raw/*53.11*/("""position: relative;
          padding-bottom: 50%;
          height: 0;
          overflow:hidden;
      """),format.raw/*57.7*/("""}"""),format.raw/*57.8*/("""
      """),format.raw/*58.7*/("""#resultChart """),format.raw/*58.20*/("""{"""),format.raw/*58.21*/("""
          """),format.raw/*59.11*/("""position: absolute;
          top: 0;
          left: 0;
          width:100%;
          height:100%;
      """),format.raw/*64.7*/("""}"""),format.raw/*64.8*/("""
    """),format.raw/*65.5*/("""</style>
  </head>
  <body style="background-color: #000;" ng-controller="homePage as home">
    <div id="myContainer" class="container h-100 d-flex" >
      <div class="jumbotron my-auto">
        <div ng-include="'"""),_display_(/*70.28*/routes/*70.34*/.Assets.versioned("html/headerNavBar/navBar.html")),format.raw/*70.84*/("""'"></div>


        <div class="page-header text-center" ng-show="home.isProfileDivVisible">
          <div ng-include="'"""),_display_(/*74.30*/routes/*74.36*/.Assets.versioned("html/profile_img_and_carousel.html")),format.raw/*74.91*/("""'"></div>
        </div>
        <div ng-include="'"""),_display_(/*76.28*/routes/*76.34*/.Assets.versioned("html/sampleProjects/dataAnalysis.html")),format.raw/*76.92*/("""'"></div>

        <div id="tabular_view">
          <div  class="modal-header text-center text-uppercase" style="background-color:black;">
            <div uib-tooltip="Close tabular view" ng-click="home.hideChart()" class="pull-right" style="color:#F76658; cursor: pointer;" data-dismiss="modal"><i class="fas fa-times-circle fa-2x"></i></div>
            <h2 class="modal-title" style="color:white;">
              <b>Tabular view</b>
            </h2>
          </div>
          <div class="modal-body table-responsive">
            <table id="datatable-table" class="table table-bordered nowrap" style="autowidth: true"></table>
          </div>
        </div>



        <nav class="navbar navbar-default navbar-buttom .col-md-3 .col-md-offset-3" role="navigation">
          <div class="navbar-header">
            <div type="button" class="navbar-toggle" ng-click="isNavCollapsed = !isNavCollapsed">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </div>
          </div>
          <div class="collapse navbar-collapse" uib-collapse="isNavCollapsed">
            <ul class="nav navbar-nav fixed-bottom" style="width:100%">
              <li uib-tooltip="LinkedIn Link" class="cursor_pointer" uib-dropdown is-open="" ng-click="home.OpenTab('https://www.linkedin.com/in/amitawinash/')" ><a uib-dropdown-toggle ng-disabled="disabled"><i class="fab fa-linkedin fa-2x" style="color:#0084bf; cursor: pointer;"  target="_blank"></i></a>

              </li>
              <li uib-tooltip="Blogspot Link" class="cursor_pointer" uib-dropdown is-open="" ng-click="home.OpenTab('https://prgconcepts.blogspot.in/2015/06/insert-documents-in-mongodb.html')" ><a uib-dropdown-toggle ng-disabled="disabled"><i class="fab fa-blogger fa-2x" style="color:#F76658; cursor: pointer;"></i></a>
              </li>
              <li uib-tooltip="GitLab Link" class="cursor_pointer" uib-dropdown is-open="" ng-click="home.OpenTab('https://gitlab.com/amitawinash')"><a uib-dropdown-toggle ng-disabled="disabled">
                <svg width="24" height="24" class="tanuki-logo" viewBox="0 0 36 36">
                  <path class="tanuki-shape tanuki-left-ear" fill="#e24329" d="M2 14l9.38 9v-9l-4-12.28c-.205-.632-1.176-.632-1.38 0z"></path>
                  <path class="tanuki-shape tanuki-right-ear" fill="#e24329" d="M34 14l-9.38 9v-9l4-12.28c.205-.632 1.176-.632 1.38 0z"></path>
                  <path class="tanuki-shape tanuki-nose" fill="#e24329" d="M18,34.38 3,14 33,14 Z"></path>
                  <path class="tanuki-shape tanuki-left-eye" fill="#fc6d26" d="M18,34.38 11.38,14 2,14 6,25Z"></path>
                  <path class="tanuki-shape tanuki-right-eye" fill="#fc6d26" d="M18,34.38 24.62,14 34,14 30,25Z"></path>
                  <path class="tanuki-shape tanuki-left-cheek" fill="#fca326" d="M2 14L.1 20.16c-.18.565 0 1.2.5 1.56l17.42 12.66z"></path>
                  <path class="tanuki-shape tanuki-right-cheek" fill="#fca326" d="M34 14l1.9 6.16c.18.565 0 1.2-.5 1.56L18 34.38z"></path>
                </svg></a>
              </li>
              <li uib-tooltip="YouTube Link" class="cursor_pointer" uib-dropdown is-open="" ng-click="home.OpenTab('https://youtu.be/3Iq7fFCiGms')" ><a uib-dropdown-toggle ng-disabled="disabled"><i class="fab fa-youtube fa-2x" style="color:#f00; cursor: pointer;"></i></a>
              </li>
              <li uib-tooltip="Number of visitors" class="pull-right"><a ng-click="home.isAboutMeHorizontal = !home.isAboutMeHorizontal"><i class="fas fa-eye fa-2x" style="color:black;"></i>&nbsp """),_display_(/*121.198*/page_view),format.raw/*121.207*/("""</a></li>
            </ul>
          </div>

        </nav>
      </div>
      <a href="mailto:"""),format.raw/*127.23*/("""{"""),format.raw/*127.24*/("""{"""),format.raw/*127.25*/("""home.emailId"""),format.raw/*127.37*/("""}"""),format.raw/*127.38*/("""}"""),format.raw/*127.39*/(""""><h6 class="pull-right"><small style="color:#8bcbf3">Design and developed by <b>Amit Kumar</b></small></h6></a>
    </div>
    <div ng-include="'"""),_display_(/*129.24*/routes/*129.30*/.Assets.versioned("html/sampleProjects/dataInsertion.html")),format.raw/*129.89*/("""'"></div>
    <div ng-include="'"""),_display_(/*130.24*/routes/*130.30*/.Assets.versioned("html/howDid_I_doThis/how_did_i_do_this.html")),format.raw/*130.94*/("""'"></div>

    <script src="http://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.2.5/js/dataTables.select.min.js"></script>
    <script src="http://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(page_view:Integer): play.twirl.api.HtmlFormat.Appendable = apply(page_view)

  def f:((Integer) => play.twirl.api.HtmlFormat.Appendable) = (page_view) => apply(page_view)

  def ref: this.type = this

}


}

/*
 * This template takes a single argument, a String containing a
 * page_view to display.
 */
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Jul 02 21:54:23 IST 2018
                  SOURCE: /home/amit/Documents/ChangeSET/learnJavaAngularJs_DesignPatterns/app/views/index.scala.html
                  HASH: b5492ed62a882f0e6f42c106c966eff620db6515
                  MATRIX: 837->97|952->117|979->118|1284->396|1299->402|1361->443|2633->1688|2648->1694|2710->1735|2789->1786|2818->1787|2857->1798|2904->1818|2932->1819|2966->1826|3014->1846|3043->1847|3082->1858|3135->1884|3163->1885|3197->1892|3245->1912|3274->1913|3313->1924|3358->1942|3386->1943|3420->1950|3475->1977|3504->1978|3543->1989|3588->2007|3616->2008|3650->2015|3688->2025|3717->2026|3756->2037|3806->2060|3834->2061|3868->2068|3911->2083|3940->2084|3976->2093|4026->2116|4054->2117|4088->2124|4157->2165|4186->2166|4225->2177|4274->2199|4302->2200|4336->2207|4384->2227|4413->2228|4452->2239|4584->2344|4612->2345|4646->2352|4687->2365|4716->2366|4755->2377|4890->2485|4918->2486|4950->2491|5194->2708|5209->2714|5280->2764|5429->2886|5444->2892|5520->2947|5599->2999|5614->3005|5693->3063|9412->6753|9444->6762|9569->6858|9599->6859|9629->6860|9670->6872|9700->6873|9730->6874|9905->7021|9921->7027|10002->7086|10063->7119|10079->7125|10165->7189
                  LINES: 30->5|35->5|36->6|45->15|45->15|45->15|59->29|59->29|59->29|61->31|61->31|62->32|63->33|63->33|64->34|64->34|64->34|65->35|66->36|66->36|67->37|67->37|67->37|68->38|69->39|69->39|70->40|70->40|70->40|71->41|72->42|72->42|73->43|73->43|73->43|74->44|75->45|75->45|76->46|76->46|76->46|77->47|78->48|78->48|79->49|79->49|79->49|80->50|81->51|81->51|82->52|82->52|82->52|83->53|87->57|87->57|88->58|88->58|88->58|89->59|94->64|94->64|95->65|100->70|100->70|100->70|104->74|104->74|104->74|106->76|106->76|106->76|151->121|151->121|157->127|157->127|157->127|157->127|157->127|157->127|159->129|159->129|159->129|160->130|160->130|160->130
                  -- GENERATED --
              */
          