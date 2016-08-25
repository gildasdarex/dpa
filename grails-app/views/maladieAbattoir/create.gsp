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
                Masque de saisie/Maladie abattoir
                <g:link action="list"  class="btn btn-info pull-right">
                   <i class="ace-icon fa fa-table bigger-120"></i>
                    Affichage
                </g:link>
            </h1>
        </div><!-- /.page-header -->
        <g:if test="${flash.error}">
            <div class="alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
                </button>
                <strong>Erreur!</strong>

               ${flash.error}
                <br />
            </div>
        </g:if>
        <div class="row">
          <div class="col-xs-12">
               <g:form name="create_data" action="save" class="form-horizontal" role="form">

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Departement </label>

                        <div class="col-sm-9">

                            <g:select name="departement"
                              from="${departements}"
                              class="select2"
                              data-placeholder="departement"
                              />

                        </div>
                   </div>

                   <div class="form-group" id="commune">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Commune </label>

                        <div class="col-sm-9">

                            <g:select name="commune"
                              from="${communes}"
                              class="select2" data-placeholder="commune"  />

                        </div>
                   </div>

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Annee </label>

                        <div class="col-sm-9">

                            <g:select name="annee"
                              from="${2000..3000}"
                              class="select2" data-placeholder="annee"  />

                        </div>
                   </div>



                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Espece </label>

                        <div class="col-sm-9">

                            <g:select name="espece.id"
                              from="${especes}"
                              optionValue ="libelle"
                              optionKey ="id"
                              class="select2" data-placeholder="espece"  />
															<g:link controller="EspeceAnimaux" action="create"  class="add-filter btn btn-link">
																 <i class="fa fa-2x fa-plus-circle"></i>
															</g:link>
                        </div>

                   </div>

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Maladie </label>

                        <div class="col-sm-9">

													<g:select name="maladie.id"
														from="${maladies}"
														optionValue ="libelle"
														optionKey ="id"
														class="select2" data-placeholder="maladie"  />
														<g:link controller="MaladieAbattoirList" action="create"  class="add-filter btn btn-link">
															 <i class="fa fa-2x fa-plus-circle"></i>
														</g:link>

                        </div>
                   </div>

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Information </label>

                        <div class="col-sm-9">

                            <g:select name="information.id"
                              from="${informations}"
                              optionValue ="libelle"
                              optionKey ="id"
                              class="select2" data-placeholder="information"  />
															<g:link controller="InformationMaladieAbattoir" action="create"  class="add-filter btn btn-link">
																 <i class="fa fa-2x fa-plus-circle"></i>
															</g:link>

                        </div>
                   </div>



                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Effectif </label>

                        <div class="col-sm-8">
                            <g:textField name="effectif"  id="form-field-1" placeholder="Effectif" class="col-xs-10 col-sm-5"/>
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
