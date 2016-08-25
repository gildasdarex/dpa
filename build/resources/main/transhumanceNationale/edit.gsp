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
               Masque de saisie/Transhumance nationale

            </h1>
        </div><!-- /.page-header -->
               <div class="row">
          <div class="col-xs-12">
               <g:form name="create_data" action="update" class="form-horizontal" role="form" id="${edit_object?.id}">


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
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Provenance </label>

                        <div class="col-sm-9">

                            <g:select name="provenance.id"
                              from="${lieux}"
                              optionValue ="libelle"
                              optionKey ="id"
                              value="${edit_object?.provenance}"
                              class="select2" data-placeholder="provenance"  />

                        </div>
                   </div>

									 <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Acceuil </label>

                        <div class="col-sm-9">

                            <g:select name="acceuil.id"
                              from="${lieux}"
                              optionValue ="libelle"
                              optionKey ="id"
                              value="${edit_object?.acceuil}"
                              class="select2" data-placeholder="acceuil"  />

                        </div>
                   </div>


                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Destination </label>

                        <div class="col-sm-9">

                            <g:select name="destination.id"
                              from="${lieux}"
                              optionValue ="libelle"
                              optionKey ="id"
                             value="${edit_object?.destination}"
                              class="select2" data-placeholder="provenance"  />

                        </div>
                   </div>

									 <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Information </label>

                        <div class="col-sm-9">

                            <g:select name="information.id"
                              from="${informations}"
                              optionValue ="libelle"
                              optionKey ="id"
                             value="${edit_object?.information}"
                              class="select2" data-placeholder="information"  />

                        </div>
                   </div>



                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Valeur </label>

                        <div class="col-sm-8">
                            <g:textField name="valeur"  id="form-field-1"
                            value="${edit_object?.valeur}"
                            placeholder="valeur" class="col-xs-10 col-sm-5"/>
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
