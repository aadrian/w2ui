//= require jquery/dist/jquery.js
//= require w2ui/w2ui-1.4.2.js
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
