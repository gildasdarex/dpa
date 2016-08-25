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
                Affichage/${page_title(str: controllerName)}
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
        <div class="row">
          <div class="col-xs-12">
              <export:formats formats="['csv', 'excel', 'ods', 'pdf', 'xml']" />
               <table id="simple-table" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Libelle</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${list_object?}" var="item">
                      <tr>
                        <td>${item?.libelle}</td>

                        <td>
                            <div class="hidden-sm hidden-xs btn-group">

                                <g:link action="edit" id="${item?.id}" class="btn btn-xs btn-info">
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </g:link>


                                <g:link action="delete" id="${item?.id}" class="btn btn-xs btn-danger"
                                        onclick="return confirm('Etes vous sur de vouloir supprimer?');">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </g:link>
                            </div>
                        </td>
                    </tr>
                   </g:each>

                </tbody>
             </table>
        </div>
      </div>
	</body>
</html>
