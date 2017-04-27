$(document).ready(function() {
	$("input[type='radio']").change(function() {
		$("#delete").show();
		var radio = $(this).closest("tr");
		console.log(radio);
		var busId = radio.find("td:eq(1)").text();
		var busName = radio.find("td:eq(2)").text();
		var busType = radio.find("td:eq(3)").text();
		var seats = radio.find("td:eq(4)").text();
		var startingPoint = radio.find("td:eq(5)").text();
		var endPoint = radio.find("td:eq(6)").text();
		var busNumber = radio.find("td:eq(7)").text();

		$("input[name='busId']").val(busId);
		$("input[name='busName']").val(busName);
		$("input[name='busType']").val(busType);
		$("input[name='startingPoint']").val(startingPoint);
		$("input[name='endPoint']").val(endPoint);
		$("input[name='seats']").val(seats);
		$("input[name='busNumber']").val(busNumber);
	});
});

var seats = [];
var n = 0;

$(document).ready(function() {
	$("button").click(function() {
		$.each($("input[name='check']:checked"), function() {
			seats.push($(this).val());
			var display = $('#display');
			$.unique(seats);
			var seat=$(this).val();
			n = seats.length;
			$("#totalseats").val(seats.length);
			console.log(n);
			display.find('tr').each(function(){	
		         var trow = $(this);
		         if(trow.index() === 0){
		        	 trow.append('<input type="text" id="seat'+seats.length+'"name="seat'+seats.length+'"/>');
		        	 var value="#seat"+seats.length; 
		        	 console.log(value);
		        	 if ($(value).val().length <= 0) {
		                 $(value).val(seat);
		        	 }
		        	 console.log(seats);
		         }
		     });
		});
		seats.length = 0;
	});
	 $(("input[name='value']"), function () {
         if ($(this).val().length <= 0) {
             $(this).hide();
         }
         else {
             console.log("TEXTBOX IS NOT EMPTY");
             $(this).show();
         }
     });
});

/*
$(document).ready(function() {
	var display = $('#display');
	iter = 0;
	$("input[type='checkbox']").change(function () {
	 if($(this).is(":checked")) {
	var selectedSeatNumber = $(this).closest("td");
	 seatNumber = selectedSeatNumber.context.id;
	 display.find('tr').each(function(){
         var trow = $(this);
         
         if(trow.index() === 0){
             trow.append('<td></td><br>');
         }else{
             trow.append('<td><input type="text" id="bs'+iter+'" name="bs'+iter+'"/></td><br>');
            var value="#bs"+iter;
            console.log(value);
            $(value).val(seatNumber);
         }
     });
     iter += 1;
}
	 else{
		 var selectedSeatNumber = $(this).closest("td");
		 console.log(selectedSeatNumber);
		 seatNumber = selectedSeatNumber.context.id
		 ;
		 console.log("seatNumber");
		 console.log(seatNumber);
		 iter -= 1;
		 var values="#bs"+iter;
          var vv= $(values).val();
		 $(values).remove();
		 console.log(selectedSeatNumber);
		  console.log(seatNumber);  
		  console.log(iter); 
		   console.log(values);
		   console.log(vv);
	 }
	 $("#noofseatselectedbyuser").val(iter);
})
});*/