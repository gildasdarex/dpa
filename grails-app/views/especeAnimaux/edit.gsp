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
               Masque de saisie/Espece animale
               
            </h1>
        </div><!-- /.page-header -->
        <div class="row">
          <div class="col-xs-12">
               <g:form name="connexe" action="update" class="form-horizontal" role="form" id="${edit_object?.id}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Libelle </label>

                        <div class="col-sm-9">
                            <g:textField name="libelle"  id="form-field-1"  class="col-xs-10 col-sm-5" value="${edit_object?.libelle}"/>
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Conventionnel </label>

                        <div class="col-sm-9">
                            <g:checkBox name="is_conventionnel" value="${edit_object?.is_conventionnel}" class="col-xs-10 col-sm-5"/>
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
