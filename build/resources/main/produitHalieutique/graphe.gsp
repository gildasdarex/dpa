<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Blank Page - Ace Admin</title>

		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <asset:stylesheet src="application.css"/>

	</head>

	<body class="no-skin">
        <div class="row-fluid" ng-app="Dpa" ng-controller="grapheController">
        <div class="table-header">
            
            <select
                ng-repeat="key in keys"    
                chosen
                class="select2"    
                ng-model="params[key]"
                data-placeholder="{{key}}"
                no-results-text="'Pas de données'"
                ng-options="item[key] for item in data_json[key]"
                ng-change="paramChange()"
                >
                <option value=""></option>
            </select>
            
            
            <select
                chosen
                class="select2" 
                ng-model="main_param"
                data-placeholder=""
                no-results-text="'Pas de données'"
                ng-options="item for item in keys"
                ng-change="paramChange()"
                >
                <option value=""></option>
            </select>
        </div>
            
        <div class="btn-group pull-right">
            <button ng-click="grapheChange('Line Chart')" type="button" class="btn btn-primary">Line chart</button>
            <button ng-click="grapheChange('Bar Chart')" type="button" class="btn btn-primary">Bar chart</button>
            <button ng-click="grapheChange('Pie Chart')" type="button" class="btn btn-primary">Pie chart</button>
        </div>
            
            
        <canvas id="bar"  class="chart chart-bar" chart-data="data_graphe" ng-show="params_graphe.nom === 'Bar Chart'" chart-labels="labels" chart-legend="true">
                
        </canvas>
            
        <canvas id="line"  class="chart chart-line" chart-data="data_graphe" ng-show="params_graphe.nom === 'Line Chart'" chart-labels="labels" chart-legend="true">
            
        </canvas>
            
        <canvas id="pie"  class="chart chart-pie" chart-data="data_graphe" ng-show="params_graphe.nom === 'Pie Chart'" chart-labels="labels" chart-legend="true">
                
        </canvas>
    </div>

    <!-- fin formulaire creation-->
        
        <g:render template="/templates/graphe_js"/>
	</body>
</html>