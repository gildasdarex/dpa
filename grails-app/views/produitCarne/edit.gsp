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
               Masque de saisie/Produits Carnes

            </h1>
        </div><!-- /.page-header -->
               <div class="row">
          <div class="col-xs-12">
               <g:form name="create_data" action="update" class="form-horizontal" role="form" id="${edit_object?.id}">

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Origine </label>

                        <div class="col-sm-9">

                            <g:select name="origine"
                              from="${lieux}"
                              class="select2"
                              value="${edit_object?.origine}"
                              data-placeholder="origine"
                              />

                        </div>
                   </div>

                   <div class="form-group" id="commune">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Destination </label>

                        <div class="col-sm-9">

                            <g:select name="destination"
                              from="${lieux}"
                             value="${edit_object?.destination}"
                              class="select2" data-placeholder="destination"  />

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
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Nature </label>

                        <div class="col-sm-9">

                            <g:select name="nature"
                              from="${['Exportation','Importation']}"
                              value="${edit_object?.nature}"
                              class="select2" data-placeholder="nature"  />

                        </div>
                   </div>

                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-top" for="duallist"> Produit </label>

                        <div class="col-sm-9">

                            <g:select name="produit.id"
                              from="${produits}"
                              optionValue ="libelle"
                              optionKey ="id"
                              value="${edit_object?.produit}"
                              class="select2" data-placeholder="produit"  />

                        </div>
                   </div>



                   <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Valeur </label>

                        <div class="col-sm-8">
                            <g:textField name="valeur"  id="form-field-1"
                            value="${edit_object?.valeur}"
                            placeholder="Valeur" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>

										<div class="form-group">
												 <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Unite </label>

												 <div class="col-sm-8">
														 <g:textField name="unite"  value="${edit_object?.unite}" id="form-field-1" placeholder="Unite" class="col-xs-10 col-sm-5"/>
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
