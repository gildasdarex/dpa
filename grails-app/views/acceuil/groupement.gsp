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
                Module groupement
                
            </h1>
        </div><!-- /.page-header -->
        <div class="row">
          <div class="col-xs-12">
               <div class="row">
                    <div class="col-sm-6">
                        <div class="dd" id="nestable">
                            <ol class="dd-list">
                                <li class="dd-item" data-id="1">
                                    <div class="dd-handle">
                                        <g:link controller="groupementEleveur" action="list">
                                            Groupement des eleveurs
                                       </g:link>
                                        
                                        
                                    </div>
                                </li>
                                
                                <li class="dd-item" data-id="1">
                                    <div class="dd-handle">
                                       <g:link controller="groupementFemme" action="list">
                                            Groupement des femmes
                                       </g:link>
                                       
                                    </div>
                                </li>

                            </ol>
                        </div>
                    </div>

                    <div class="vspace-16-sm"></div>

                    <div class="col-sm-6">
                        <div class="dd dd-draghandle">
                            <ol class="dd-list">
                                <li class="dd-item dd2-item" data-id="13">
                                    
                                    <div class="dd2-content">
                                      <g:link controller="ficheEleveur" action="list">
                                            Fiche  des eleveurs
                                       </g:link>
                                    </div>
                                </li>
                             
                            </ol>
                        </div>
                    </div>
                </div><!-- PAGE CONTENT ENDS -->
         </div>
        </div>      
	</body>
</html>
