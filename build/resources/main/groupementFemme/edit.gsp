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
               Masque de saisie/Groupement femmes

            </h1>
        </div><!-- /.page-header -->
               <div class="row">
          <div class="col-xs-12">
               <g:form name="create_data" action="update" class="form-horizontal" role="form" id="${edit_object?.id}">

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Departement </label>

                        <div class="col-sm-9">

                            <g:select name="departement"
                              from="${departements}"
                              class="select2"
                              value="${edit_object?.departement}"
                              data-placeholder="departement"
                              />

                        </div>
                   </div>

                   <div class="form-group" id="commune">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Commune </label>

                        <div class="col-sm-9">

                            <g:select name="commune"
                              from="${departements}"
                             value="${edit_object?.commune}"
                              class="select2" data-placeholder="departement"  />

                        </div>
                   </div>

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Annee </label>

                        <div class="col-sm-9">

                            <g:select name="annee"
                              from="${2000..3000}"
                              value="${edit_object?.annee}"
                              class="select2" data-placeholder="annee"  />

                        </div>
                   </div>


                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Activite </label>

                        <div class="col-sm-9">

                            <g:select name="activite.id"
                              from="${activites}"
                             value="${edit_object?.activite}"
                              optionValue ="libelle"
                              optionKey ="id"
                              class="select2" data-placeholder="activite"  />

                        </div>
                   </div>


                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Fonctionnement </label>

                        <div class="col-sm-9">

                            <g:select name="fonctionnement.id"
                              from="${fonctionnements}"
                             value="${edit_object?.fonctionnement}"
                              optionValue ="libelle"
                              optionKey ="id"
                              class="select2" data-placeholder="fonctionnement"  />

                        </div>
                   </div>

									 <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Denomination </label>

                        <div class="col-sm-8">
                            <g:textField name="denommination"  value="${edit_object?.denommination}"   id="form-field-1" placeholder="denomination" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>


                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Effectif </label>

                        <div class="col-sm-8">
                            <g:textField name="effectif"  id="form-field-1"
                            value="${edit_object?.effectif}"
                            placeholder="Effectif" class="col-xs-10 col-sm-5"/>
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
