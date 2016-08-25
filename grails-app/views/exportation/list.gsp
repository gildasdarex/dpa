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
     <div class="page-header">
            <h1>
                Affichage/Exportation
                <div class="pull-right">
                    <div class="btn-group">
                        <button data-toggle="dropdown" class="btn dropdown-toggle">
                            Actions
                            <span class="ace-icon fa fa-caret-down icon-on-right"></span>
                        </button>
                        <ul class="dropdown-menu dropdown-default">
                            <li>
                              <a href="" onclick="document.getElementById('upload').click(); return false">
                                  <i class="ace-icon fa fa-cloud-upload"></i>
                                  Importer un fichier excel
                              </a>
                            </li>
                            <li>
                              <g:link action="graphe" >
                                  <i class="ace-icon fa fa-bar-chart-o"></i>
                                  Graphes
                              </g:link>
                            </li>
                            <li>
                              <g:link action="list_croise" >
                                  <i class="ace-icon fa fa-asterisk"></i>
                                  Liste croise
                              </g:link>
                            </li>
                        </ul>
                    </div><!-- /.btn-group -->

                    <g:link action="create"  class="btn btn-info">
                       <i class="ace-icon fa fa-plus bigger-120"></i>
                        Masque de saisie
                    </g:link>
                </div>

            </h1>
        </div><!-- /.page-header -->
        <g:uploadForm action="upload" id="upload_excel">
          <input type="file" id="upload" name="upload_file" onchange="javascript:this.form.submit();"
                 style="visibility: hidden; width: 1px; height: 1px"/>
        </g:uploadForm>
        <g:if test="${flash.success}">
            <div class="alert alert-info">
                <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
                </button>
                <strong>Success!</strong>

               ${flash.success}
                <br />
            </div>
        </g:if>
        <div class="row">
          <div class="col-xs-12">

              <div id="accordion" class="accordion-style1 panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                <i class="ace-icon fa fa-angle-down bigger-110" data-icon-hide="ace-icon fa fa-angle-down" data-icon-show="ace-icon fa fa-angle-right"></i>
                                &nbsp;Filtrer
                            </a>
                        </h4>
                    </div>

                      <div class="panel-collapse collapse" id="collapseOne">
                        <div class="panel-body">
                                     <filterpane:filterPane domain="Exportation"
                             associatedProperties="espece.libelle, provenance.libelle, destination.libelle"/>
                        </div>
                      </div>
                    </div>
              </div>

			</div>
               <export:formats formats="['csv', 'excel', 'ods', 'pdf', 'xml']" />
               <table id="simple-table" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Date de saisie</th>
                        <th>Departement</th>
                        <th>Commune</th>
                        <th>Annee</th>
                        <th>Espece</th>
                        <th>Sexe</th>
                        <th>Provenance</th>
                        <th>Destination</th>
                        <th>Effectif</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${list_object?}" var="item">
                      <tr>
                        <td>${formatDate(format:'dd-MM-yyyy',date:item?.lastUpdated)}</td>
                        <td>${item?.departement}</td>
                        <td>${item?.commune}</td>
                        <td>${item?.annee}</td>
                        <td>${item?.espece}</td>
                        <td>${item?.sexe}</td>
                        <td>${item?.provenance}</td>
                        <td>${item?.destination}</td>
                        <td>${item?.effectif}</td>
                        <td>
                            <div class="hidden-sm hidden-xs btn-group">

                                <g:link action="edit" id="${item?.id}" class="btn btn-xs btn-info">
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </g:link>


                                <g:link action="delete" id="${item?.id}" class="btn btn-xs btn-danger" onclick="return confirm('Etes vous sur de vouloir supprimer?');">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </g:link>
                            </div>
                        </td>
                    </tr>
                   </g:each>

                </tbody>
             </table>

            <g:paginate total="${objectCount}" params="${filterParams}" />

        </div>
	</body>
</html>
