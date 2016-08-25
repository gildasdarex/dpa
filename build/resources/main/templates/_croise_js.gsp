<%@page expressionCodec="none" %>

<asset:javascript src="chosen.js"/>
<asset:javascript src="chosen.jquery.min.js"/>
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
    
    var app = angular.module('Dpa', ['localytics.directives']);
    app.controller('croiseController', function($scope) {
        
           $scope.liste = [];
           $scope.allData = [];
           $scope.headers = {ligne:'departement',horizontal:'commune',vertical:'annee'};

           $scope.header_horizontal = [];
           $scope.header_vertical = [];
           
           $scope.data_ligne=[];
           $scope.data_horizontal=[];
           $scope.data_vertical=[];

           $scope.listeData = ${data};
           $scope.keys =  ${fields};
        
           var main_data = "effectif";
           if($scope.keys.contains("valeur")) main_data = "valeur";
           if($scope.keys.contains("prix")) main_data = "prix";
           $scope.keys.remove(main_data);
        
           
           

           $scope.paramChange = function ()
           {
            $scope.listeData = ${data};   
            $scope.liste = [];
            $scope.keys_horizontal = alasql('SELECT distinct '+ $scope.headers.horizontal+ ' FROM ? ',[$scope.listeData]);
            $scope.data_vertical = alasql('SELECT distinct '+$scope.headers.vertical+' FROM ? ',[$scope.listeData]);
            $scope.data_ligne = alasql('SELECT distinct '+ $scope.headers.ligne+ ' FROM ? ',[$scope.listeData]);
            
            for (var i = 0; i < $scope.data_ligne.length; i++) {
                
                    $scope.data_horizontal = alasql('SELECT distinct '+ $scope.headers.horizontal+ ' FROM ? where '+ $scope.headers.ligne+' = "'+$scope.data_ligne[i][$scope.headers.ligne] +'"' ,[$scope.listeData]);
                    var item_total = {};
                    item_total[$scope.headers.horizontal] = 'Total';
                   $scope.data_horizontal.push(item_total);
                   var item = {'ligne':$scope.data_ligne[i][$scope.headers.ligne],'span':$scope.data_horizontal.length,'data':[]};
                    var item_i = {};
                
                   for (var j = 0; j < $scope.data_horizontal.length; j++) 
                   {
                       item_i = {'horizontal':$scope.data_horizontal[j][$scope.headers.horizontal]};
                       var sum = 0;
                       for (var k= 0; k < $scope.data_vertical.length; k++) {
                           var result = 0;
                           if($scope.data_horizontal[j][$scope.headers.horizontal]==="Total") result = $scope.somme_by_vertical($scope.data_ligne[i][$scope.headers.ligne],$scope.data_vertical[k][$scope.headers.vertical]);
                           else result  = $scope.retrieve($scope.data_ligne[i][$scope.headers.ligne],$scope.data_horizontal[j][$scope.headers.horizontal],$scope.data_vertical[k][$scope.headers.vertical]);
                           item_i[$scope.data_vertical[k][$scope.headers.vertical]] = result;
                           sum = sum + result;
                       };
                       item_i['total'] = sum;
                     item.data.push(item_i);  
                   }
                
                  
                   $scope.liste.push(item);
                 }
           };


            $scope.retrieve = function (ligne,horizontal,vertical) {
                $scope.listeData = ${data};
                var data = alasql('SELECT '+ main_data +' FROM ? where '+ $scope.headers.horizontal+'="'+horizontal+'" and '+ $scope.headers.vertical+'="'+vertical+'" and '+ $scope.headers.ligne+'="'+ligne+'"',[$scope.listeData]);
                var somme = 0;
                for (var p = 0; p < data.length; p++) {
                        somme = somme + parseInt(data[p][main_data]);
                    }
                return somme;
            };
            
            $scope.somme_by_vertical = function (ligne,vertical) {
                var data = alasql('SELECT '+ main_data +' FROM ? where ' + $scope.headers.vertical+'="'+vertical+'" and '+ $scope.headers.ligne+'="'+ligne+'"',[$scope.listeData]);
                var somme = 0;
                for (var p = 0; p < data.length; p++) {
                        somme = somme + parseInt(data[p][main_data]);
                    }
                return somme;
            };
            
            
           $scope.paramChange();
        
    });
</script>