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


$('table#test tr.seats td#seats div#3').prop("disabled", true);

$("#3").prop('disabled',true);
$("#3").prop('disabled','disabled');