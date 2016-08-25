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
                Modification
               
            </h1>
        </div><!-- /.page-header -->
        <div class="row">
          <div class="col-xs-12">
               <g:form name="connexe" action="update" class="form-horizontal" role="form" id="${edit_object?.id}">
                    
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nom </label>

                        <div class="col-sm-9">
                            <g:textField name="nom"  value="${edit_object?.nom}" id="form-field-1" placeholder="Nom" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Prenom </label>

                        <div class="col-sm-9">
                            <g:textField name="prenom"  value="${edit_object?.prenom}" id="form-field-1" placeholder="Prenom" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Date de naissance </label>

                        <div class="col-sm-9">
                            <g:datePicker name="birthday" precision="day"  value="${edit_object?.birthday}" />
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Profession </label>

                        <div class="col-sm-9">
                            <g:textField name="profession" value="${edit_object?.profession}"  id="form-field-1" placeholder="Profession" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Lieu de travail </label>

                        <div class="col-sm-9">
                            <g:textField name="lieu_de_travail" value="${edit_object?.lieu_de_travail}"  id="form-field-1" placeholder="Lieu de travail" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Annee de service</label>

                        <div class="col-sm-9">

                            <g:select name="annee_de_service"
                             value="${edit_object?.annee_de_service}"          
                              from="${2000..3000}"
                              class="select2" data-placeholder="annee"  />

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
