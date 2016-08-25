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
                Module Outil
                
            </h1>
        </div><!-- /.page-header -->
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
               <div class="row">
                    <div class="col-sm-6">
                        <div class="dd" id="nestable">
                            <ol class="dd-list">
                                <li class="dd-item" data-id="1">
                                    <div class="dd-handle">
                                        <a onclick="document.getElementById('upload').click(); return false">
                                            Base de fichiers
                                       </a>                                        
                                    </div>
                                </li>
                                
                            </ol>
                        </div>
                    </div>

                    <div class="vspace-16-sm"></div>

                    
                </div><!-- PAGE CONTENT ENDS -->
         </div>
            <g:uploadForm controller="outil" action="upload" id="upload_file">
                 <input type="file" id="upload" name="upload_file" onchange="javascript:this.form.submit();" 
                 style="visibility: hidden; width: 1px; height: 1px"/>
        </g:uploadForm>  
        </div>      
	</body>
</html>
