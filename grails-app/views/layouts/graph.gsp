<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Blank Page - Ace Admin</title>

		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="fp.css"/>
        
        <asset:javascript src="application.js"/>
        <asset:javascript src="fp.js"/>
        
        <export:resource />

	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							LOGI-DPA
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
				  <g:render template="/templates/nav"/>
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			
            

			<div class="main-content">
				<div class="main-content-inner">
					

					<div class="page-content">

						<g:render template="/templates/settings"/>

						<!--<div class="page-header">
							<h1>
								Form Elements
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Common form elements and layouts
								</small>
							</h1>
						</div>--><!-- /.page-header -->

						<!--<div class="row">
							<div class="col-xs-12">-->
								<!-- PAGE CONTENT BEGINS -->
								<g:layoutBody/>
								<!-- PAGE CONTENT ENDS -->
							<!-- </div> -->
						<!-- </div> -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->


			<g:render template="/templates/footer"/>
        </div>

		
        
	</body>
</html>
