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
								Masque de saisie/${page_title(str: controllerName)}
                <g:link action="list"  class="btn btn-info pull-right">
                   <i class="ace-icon fa fa-table bigger-120"></i>
                    Affichage
                </g:link>
            </h1>
        </div><!-- /.page-header -->
        <div class="row">
          <div class="col-xs-12">
               <g:form name="connexe" action="save" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Libelle </label>

                        <div class="col-sm-9">
                            <g:textField name="libelle"  id="form-field-1" placeholder="Libelle" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>


                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">
                           <g:submitButton name="save" value="Enregistrer" class="btn btn-info">
                             <i class="ace-icon fa fa-check bigger-110"></i>
                             Enregistrer
                           </g:submitButton>


                            &nbsp; &nbsp; &nbsp;

                            <g:field type="reset" name="myReset" value="Reset" class="btn">
                              <i class="ace-icon fa fa-undo bigger-110"></i>
                                Initialiser
                            </g:field>

                    </div>
                </div>
              </g:form>
             </div>
        </div>
	</body>
</html>
