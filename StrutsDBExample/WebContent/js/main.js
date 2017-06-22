$(document).ready(function() { 
	$("#deleteinfo").hide();
	$("#downloadfile").hide();
	$("input[type='radio'][name='deleteinfo']").change(function() {
		var radio = $(this).closest("tr");
		$("#downloadfile").attr('disabled', 'disabled');
		$("#downloadfile").hide();
		$("#deleteinfo").show();
		fileId = radio.find("td:eq(0)").text();
		fileName = radio.find("td:eq(1)").text();
		
		console.log(fileName);
		console.log(fileId);
		$("input[name='fileNames']").val(fileName);
		$("input[name='fileId']").val(fileId);
	})
	$("input[type='radio'][name='downloadfile']").change(function() {
		var radio = $(this).closest("tr");
		$("#deleteinfo").attr('disabled', 'disabled');//.attr('disabled', 'disabled');
		$("#deleteinfo").hide();
		$("#downloadfile").show();
		fileId = radio.find("td:eq(0)").text();
		fileName = radio.find("td:eq(1)").text();
		
		console.log(fileName);
		console.log(fileId);
		$("input[name='fileNames']").val(fileName);
		$("input[name='fileId']").val(fileId);
	})
});