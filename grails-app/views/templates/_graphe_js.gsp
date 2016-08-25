<%@page expressionCodec="none" %>

<asset:javascript src="chosen.js"/>
<asset:javascript src="chosen.jquery.min.js"/>
<asset:javascript src="Chart.js/Chart.js"/>
<asset:javascript src="angular-chart.js/dist/angular-chart.min.js"/>
<asset:javascript src="angular-chart.js/dist/angular-chart.min.js"/>
<asset:javascript src="alasql/dist/alasql.min.js"/>

<script>
   Array.prototype.remove = function(elem, all) {
      for (var i=this.length-1; i>=0; i--) {
        if (this[i] === elem) {
            this.splice(i, 1);
            if(!all)
              break;
        }
      }
      return this;
    };
    
    Array.prototype.contains = function(obj) {
        var i = this.length;
        while (i--) {
            if (this[i] === obj) {
                return true;
            }
        }
        return false;
   };
    
    var app = angular.module('Dpa', ['localytics.directives','chart.js']);
    app.controller('grapheController', function($scope) {
        $scope.params = {};
        $scope.data_json = {};
        $scope.labels = [];
        $scope.data_graphe = [];
        $scope.params_graphe = {
            nom:'Line Chart', 
            clazz:'Line Chart',
            options: 
            {
            responsive: true
            }
          };
        
        $scope.data = ${data};
        $scope.keys =  ${fields};
                
        var main_data = "effectif";
        if($scope.keys.contains("valeur")) main_data = "valeur";
        if($scope.keys.contains("prix")) main_data = "prix";
        if($scope.keys.contains("quantite")) main_data = "quantite";
        $scope.keys.remove(main_data);
        
        $scope.main_param= $scope.keys[$scope.keys.length - 1];
        
        
        
        for (k = 0; k < $scope.keys.length; k++) {
          var data = alasql('SELECT distinct ' + $scope.keys[k] + ' FROM ? ', [$scope.data]);
          $scope.data_json[$scope.keys[k]] = data ;
         }
        
        $scope.grapheChange = function (chart){
           $scope.params_graphe.nom = chart;
           if($scope.params_graphe.nom === 'Line Chart')  $scope.params_graphe.clazz = 'chart-line';
           else if($scope.params_graphe.nom === 'Bar Chart')  $scope.params_graphe.clazz = 'chart-bar';
           else $scope.params_graphe.clazz = 'chart-pie';
           $scope.buildSql();
        }
        
        
        $scope.paramChange = function (){
            $scope.labels = [];
            $scope.data = [];
            $scope.buildSql();
        };
        
        
        
        
        $scope.buildSql = function () {
            $scope.data = ${data};
            var dataListe=[];
            var labels=[];
            $scope.labels = [];
            $scope.data_graphe = [];
            var sql = 'select '+$scope.main_param+' as main_param , SUM(' + main_data +') as ' + main_data + ' from ? where ';
            
            console.log($scope.params);
            
            for(var param in $scope.params){
              console.log(param);
              sql = sql + param +' ="'+ $scope.params[param][param]+'" and ';
            }
            
            sql = sql.slice(0,-5);
            sql = sql + ' GROUP BY '+$scope.main_param;
            
            console.log(sql);
            var data = alasql(sql,[$scope.data]);
            

            for (k = 0; k < data.length; k++) {
                $scope.labels.push(data[k]['main_param']);
                dataListe.push(parseInt(data[k][main_data]));
            }
            
            if($scope.params_graphe.nom === 'Line Chart' || $scope.params_graphe.nom === 'Bar Chart') $scope.data_graphe.push(dataListe);
            else $scope.data_graphe = dataListe;
            
        }

    });
</script>