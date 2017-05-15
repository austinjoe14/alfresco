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
	$("#femaleSeat").css('background-color', 'brown');
	$("#Unavailable").css('background-color', 'black');
	i=0;
	var booked=new Array();
	$("input[type='checkbox']").attr('checked', false);
	console.log($("input[type='hidden'] ").val());
	var Seats=$("input[type='hidden'] ").val(); //Total number of seats already booked
	var females=$("input[type='hidden'][name='']").val();
	for(iter=0;iter<Seats;iter++){		
		var value = "seatss" + iter;
		console.log(value);
		booked[i] = $("input[type='hidden'][name='" + value + "']").val();
		coloringseat="#"+booked[i];
		$(coloringseat).css('background-color', 'black');
		i++;
		
		var valuess = "females" + iter;
		var fs=$("input[type='hidden'][name='" + valuess + "']").val();
		console.log("FEMALEEEEEEEE"+fs);
		var coloringFemaleSeats="#"+fs;
		$(coloringFemaleSeats).css('background-color', 'brown');
}
console.log("booked"+i);
for(var iter1=0;iter1<i;iter1++){
	console.log(booked[iter1]);
}
console.log("booked after");
var seats=new Array();
var noofSeats=0;
var myform = $('#chooseseats');
iter = 0;
	
/*	*/
$("input[type='checkbox']").change(function () {
	if($(this).is(":checked"))  {
			seats.push($(this).val());
			var display = $('#display');
			$.unique(seats);
			var seat=$(this).val();
			n = seats.length;
			/*$("#totalseats").val(seats.length);*/
			console.log(n);
			for(var iter1=0;iter1<Seats;iter1++){
				console.log("seat:"	+ booked[iter1]);
				if (seatNumber == booked[iter1]) {
					alert(booked[iter1]+" is Already booked\nAlready booked seats are\n"+booked);
					$(this).attr('checked', false);
			  }
		     }
			 if($(this).is(":checked")){
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
			iter += 1;
			}
		}
		 else{
				if(iter>0) {
					iter-=1;
				}
				var selectedSeatNumber = $(this).closest("td");
				
				console.log("pop "+$(this).val());
				
				/*seats.pop($(this).val());*/
				
				/*console.log(seats);
				console.log("selectedSeatNumber"+selectedSeatNumber);
				seatNumber = selectedSeatNumber.context.id;
				console.log("seatNumber");
				console.log(seatNumber);
				var values="#"+seatNumber;
		        var vv= $(values).val();
		          
				$(values).remove();*/
				var values=$(this).val();
				console.log(values);
				/*seats.remove('$(this).val()');*/
				var index = seats.indexOf($(this).val());
				if (index > -1) {
					seats.splice(index, 1);
				}
				$(values).remove();
				console.log("after pop "+seats);
		 }
	$("#totalseats").val(iter);
	});
});

$(document).ready(function() {
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
	window.onhashchange=function(){window.location.hash="no-back-button";}
}); 
