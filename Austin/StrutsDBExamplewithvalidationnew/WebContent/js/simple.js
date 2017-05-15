$(document).ready(function() {
	$("input[type='radio'][name='viewBus']").click(function() {
		$("#viewSelectedBusForBookingform").show();
		console.log("hi");
		var id = $(this).closest("tr");
		busNumber = id.find("td:eq(2)").text();
		busName=id.find("td:eq(1)").text();
		console.log(busNumber);
		$("input[name='busNumber']").val(busNumber);
		$("input[name='busName']").val(busName);
	})
	
});

$(document).ready(function() {
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
	window.onhashchange=function(){window.location.hash="no-back-button";}
}); 

$(function(){
    $('[type="date"].min-today').prop('min', function(){
        return new Date().toJSON().split('T')[0];
    });
});
