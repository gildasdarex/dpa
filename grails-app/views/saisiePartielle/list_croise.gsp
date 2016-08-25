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
        <div class="row-fluid" ng-app="Dpa" ng-controller="croiseController">
        <div class="table-header">
            
            <select
                chosen
                class="select2" 
                ng-model="headers.ligne"
                data-placeholder=""
                no-results-text="'Pas de données'"
                ng-options="item for item in keys"
                ng-change="paramChange()"
                >
                <option value=""></option>
            </select>
            
            <select
                chosen
                class="select2" 
                ng-model="headers.horizontal"
                data-placeholder=""
                no-results-text="'Pas de données'"
                ng-options="item for item in keys"
                ng-change="paramChange()"
                >
                <option value=""></option>
            </select>
            
            
            <select
                chosen
                class="select2" 
                ng-model="headers.vertical"
                data-placeholder=""
                no-results-text="'Pas de données'"
                ng-options="item for item in keys"
                ng-change="paramChange()"
                >
                <option value=""></option>
            </select>
        </div>
            
       
            
            
        <div class="gsp-scroll">
            <table class="table table-striped table-bordered table-hover" id="table-croise">
                <thead>
                    <tr >
                        <th>

                        </th>
                        <th>

                        </th>
                        <th ng-repeat="header in data_vertical">{{header[headers.vertical]}}</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat-start="item in liste| filter:search">
                        <td rowspan="{{item.span}}">{{item.ligne}}</td>
                        <td >{{item.data[0].horizontal}}</td>
                        <td ng-repeat="header in data_vertical">{{item.data[0][header[headers.vertical]]}}</td>
                        <td class="gsp-color">{{item.data[0].total}}</td>
                    </tr>

                    <tr ng-repeat="data in item.data" ng-if="!$first" class="{{data.horizontal=='Total'?'gsp-color':'' }}">
                        <td >{{data.horizontal}}</td>
                        <td ng-repeat="header in data_vertical">{{data[header[headers.vertical]]}}</td>
                        <td class="gsp-color">{{data.total}}</td>
                    </tr>

                    <tr ng-repeat-end class="gsp-color">
                    </tr>

                </tbody>
            </table>
      </div>      
            
    </div>

    <!-- fin formulaire creation-->
        
        <g:render template="/templates/croise_js"/>
	</body>
</html>