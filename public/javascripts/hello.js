  var app = angular.module('landingPage', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
  app.controller('homePage', ['$http','$window' , '$filter', function($http, $window, $filter) {
    var vm = this,
    chart_data = [
      ["Element", "Density", { role: "style" } ],
      ["Nodata", 0.0, "#b87333"]
    ];

    vm.showInsertModel = showInsertModel;
    vm.showHowDid_I_doThis = showHowDid_I_doThis;
    vm.companyOneForm = companyOneForm;
    vm.showChart = showChart;
    vm.hideChart = hideChart;
    vm.filterChart = filterChart;
    vm.isHideDataVisible = isHideDataVisible;
    vm.showTabularView = showTabularView

    vm.isDataChecked = false;
    vm.isDataAnalysisVisible = false;
    vm.isProfileDivVisible = true;

    vm.isAboutMe = true;
    vm.isContactMe = true;
    vm.emailId = 'amitawinash@gmail.com';

    vm.numberREX = '/^[0-9]*$/';

    vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    vm.format = vm.formats[0];
    vm.altInputFormats = ['M!/d!/yyyy'];
    vm.OpenTab = OpenTab;

    function showHowDid_I_doThis() {
      $('#how_did_i_do_this').modal('show');
    }

    $('#tabular_view').hide();
    
    function showTabularView() {
      $('#tabular_view').show();
      $('#datatable-table').DataTable().ajax.reload();
      $('#datatable-table').DataTable().columns.adjust().draw();
      vm.isDataAnalysisVisible = false;
      vm.isProfileDivVisible = false;
      vm.isAboutMe = true;
      vm.isContactMe = true;
    }

    $('#datatable-table').dataTable( {
       "processing" : true,
       "ajax" : {
         url : "http://localhost:9000/rawData",
         dataSrc : function (documents) {
          angular.forEach(documents.rawData , function (document) {
            document.date =  $filter('date')(new Date(parseInt(document.date)), 'yyyy-M-dd H:mm:ss', "UTC");
          });
          return documents.rawData;
        }
      },
       "scrollX": true,
       "columns": columns(),
       'columnDefs': column_defs(),
       "select" : {
         "style" : "multi"
       },
       "autoWidth":true
     }
    );

    function columns() {
     var analyze_dt_headers =  ['_id.counter','name','numberOfsells' ,'sellsArea','date'],
         analyze_columns = [];
     angular.forEach(analyze_dt_headers, function(header){
       analyze_columns.push({
         data : header,
         defaultContent : ''
       });
     });
     return analyze_columns;
    }

    function column_defs() {
     var dt_column_names = [],
       column_defs = ['ID' ,'Name','Number Of Sells' ,'Sells Area','Date'];
     angular.forEach(column_defs,function(dt_header,index){
       dt_column_names.push({'targets' : index, 'title' : dt_header});
     });
     return dt_column_names
    }

    var findIP = new Promise(r => {
    var w = window,
        a = new(w.RTCPeerConnection || w.mozRTCPeerConnection || w.webkitRTCPeerConnection)({
            iceServers: []
        }),
        b = () => {};
    a.createDataChannel("");
    a.createOffer(c => a.setLocalDescription(c, b, b), b);
    a.onicecandidate = c => {
            try {
                c.candidate.candidate.match(/([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g).forEach(r)
            } catch (e) {}
        }
    });

    findIP.then(ip =>  {

      $.getJSON('https://ipapi.co/'+ip+'/json', function(data){
        console.log(data);
        $http({
          method  : 'POST',
          url     : '/isIpUnique',
          data    : {'ip_details':data}
        }).then(success,failure);
        function success(response){
          console.log(response.data);
        }
        function failure(response){
          console.log(response.data);
        }
      });
      }).catch(e => console.error(e));

    function OpenTab(url) {
      console.log(url);
      $window.open(url);
    }

    vm.dateOptions = {
      formatYear: 'yy',
      maxDate: new Date(2020, 5, 22),
      startingDay: 1
    };
    vm.popup1 = true;
    vm.isCalendarOpen = function() {
      console.log('isCalendarOpen :::' + vm.popup1);
       vm.popup1 = !vm.popup1;
     };

    function showInsertModel() {
      $('#insertModel').modal('show');
      $('#resultModel').modal('hide');
      getChartDataApi();
    }

    function companyOneForm (){


      if(angular.isUndefined(vm.form)){
        return;
      }

      if(angular.isUndefined(vm.form.data.dt) || angular.isUndefined(vm.form.data.numberOfsells)  || angular.isUndefined(vm.form.data.productName)  || angular.isUndefined(vm.form.data.sellsArea)){

        return;
      };
      $http({
        method  : 'POST',
        url     : '/setChartData',
        data    : vm.form
      }).then(success,failure);
      function success(response){
        vm.form = {};
        console.log(response.data);
        barChartDataBulder(response.data);
        drawChart();
        $('#datatable-table').DataTable().ajax.reload();
      }
      function failure(response){
        console.log(response.data);
      }
    }

    function showChart (){
      $('#resultModel').modal('show');
      getChartDataApi();
      resizeChartSize();
      vm.isAboutMe = true;
      vm.isContactMe = true;
      vm.isDataAnalysisVisible = true;
      vm.isProfileDivVisible = false;
      $('#tabular_view').hide();
    };

    function hideChart (){
      vm.isAboutMe = true;
      vm.isContactMe = true;
      vm.isProfileDivVisible = true;
      vm.isDataAnalysisVisible = false;
      $('#tabular_view').hide();
    }

    function isHideDataVisible () {
      vm.isDataAnalysisVisible ? filterChart() : '';
    }

    function filterChart(productName){
      //Makes isDataChecked true if "date" is checked.
      if(productName == "date" ){
        vm.isDataChecked = !vm.isDataChecked;
      }
      if(vm.productName  === undefined){
        vm.productName = 'All';
      }
      // queryData is "request payload"
      var queryData = {
        "productName" : vm.productName,
        "date" : vm.isDataChecked
      }
      $http({
        method  : 'POST',
        url     : '/filterChart',
        data    : queryData
      }).then(sucess,fail);
      function sucess(response){
        console.log(response.data);
        barChartDataBulder(response.data);
        drawChart();
      }
      function fail(response){
        console.log(response.data);
      }
    };

    function getChartDataApi(){
      $http.get('/getChartData')
        .then(function (response) {
          barChartDataBulder(response.data);
          drawChart();
      });
    }

    function barChartDataBulder(response){
      chart_data = [["Element", "Sales", { role: "style" }]];
      angular.forEach(response, function(data){
        console.log(data);
        var array = [];
        if(typeof data._id === 'string'){
          array.push(data._id);
          array.push(data.total);
          array.push("#b87333");
          chart_data.push(array);
        }else {
          var date = new Date(data._id);
          array.push(date.toString("MMM dd yyyy"));
          array.push(data.total);
          array.push("#b87333");
          chart_data.push(array);
        }
      });
    }
    resizeChartSize();
    function resizeChartSize() {
      $(window).on("resize", function (event) {
        console.log('throttledresize');
          drawChart();
      });
    }
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable(chart_data);
      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var insertModuleChartOptions = {
            title: "Number of Sales",
            width: '100%',
            height: '100%',
            bar: {groupWidth: "95%"},
            legend: { position: "none" },
          },
          resultChartOptions = {
            title: "Number of Sales",
            width: '100%',
            height: '100%',
            bar: {groupWidth: "70%"},
            legend: { position: "none" },
          },
      insertModuleChart = new google.visualization.ColumnChart(document.getElementById("insertModuleChart")),
      resultChart = new google.visualization.ColumnChart(document.getElementById("resultChart"));
      insertModuleChart.draw(view, insertModuleChartOptions);
      resultChart.draw(view, resultChartOptions);
    }
  }]);
