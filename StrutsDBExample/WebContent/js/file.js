$(document).ready(function() {
	$("#downloadmultifile").hide();
	$("button").click(function() {
		var favorite = [];
		var favoriteId= [];
		$("#downloadmultifile").show();
		$.each($("input[name='downloadmultifile']:checked"), function() {
			var radio = $(this).closest("tr");
			fileId = radio.find("td:eq(0)").text();
			fileName = radio.find("td:eq(1)").text();
			favorite.push(fileName);
			favoriteId.push( fileId);
		});
		$("input[name='fileName']").val(favorite);
		$("input[name='fileIds']").val(favoriteId);
	});
});