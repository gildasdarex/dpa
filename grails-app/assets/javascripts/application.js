// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require ace/assets/js/jquery.2.1.1.min
//= require ace/assets/js/jquery.min
//= require ace/assets/js/jquery.mobile.custom.min
//= require ace/assets/js/bootstrap-datepicker.min
//= require ace/assets/js/bootstrap-timepicker.min
//= require ace/assets/js/ace-extra.min
//= require ace/assets/js/bootstrap.min
//= require ace/assets/js/jquery.bootstrap-duallistbox.min
//= require ace/assets/js/jquery.raty.min
//= require ace/assets/js/bootstrap-multiselect.min
//= require ace/assets/js/select2.min
//= require ace/assets/js/typeahead.jquery.min
//= require ace/assets/js/bootstrap-editable.min
//= require ace/assets/js/ace-editable.min
//= require ace/assets/js/ace-elements.min
//= require ace/assets/js/ace.min
//= require angular/angular.min
//= require ace/assets/js/typeahead.jquery.min
//= require dualist
//= require user_profil
//= require_tree .
//= require_self


if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}
