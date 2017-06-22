

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


var seats = [];
var n = 0;


	$("#femaleSeat").css('background-color', 'brown');
	$("#Unavailable").css('background-color', 'yellow');
	i=0;
	var booked=new Array();
	$("input[type='checkbox']").attr('checked', false);
	
	console.log($("input[type='hidden'] ").val());
	console.log($("input[type='hidden'][name='totalSeats']").val());
	var SeatsOne=$("input[type='hidden'][name='totalSeats']").val(); //Total number of seats already booked
	console.log("here "+SeatsOne);
	for(iter=0;iter<SeatsOne;iter++){
		var value = "seatss" + iter;
		booked[i] = $("input[type='hidden'][name='"+value+"']").val();
		coloringseat="#"+booked[i];
		$(coloringseat).css('background-color', 'yellow');
		i++;
		var valuess = "females" + iter;
		var fs=$("input[type='hidden'][name='"+valuess+"']").val();
		var coloringFemaleSeats="#"+fs;
		$(coloringFemaleSeats).css('background-color', 'brown');
		
}
var seats=new Array();
var noofSeats=0;
var myform = $('#chooseseats');
var iter = 0;
$("#totalseats").val(iter);	
$("input[type='checkbox']").change(function () {
	if($(this).is(":checked"))  {
			/*n = seats.length;
			$("#totalseats").val(seats.length);
			console.log(n);*/
			for(var iter1=0;iter1<SeatsOne;iter1++){
				console.log("seat:"	+ booked[iter1]);
				var selectedSeatNumber = $(this).closest("td");
				seatNumber = selectedSeatNumber[0].id;
				console.log(seatNumber);
				if (seatNumber == booked[iter1]) {
					alert("Already booked seat");
					$(this).prop('checked', false);
				}
				else{
					seats.push($(this).val());
					var display = $('#display');
					$.unique(seats);
					var seat=$(this).val();
				}
		     }
			 if($(this).is(":checked")){
			 display.find('tr').each(function(){	
		         var trow = $(this);
		         
		        	 trow.append('<input type="hidden" id="seat'+seats.length+'"name="seat'+seats.length+'"/>');
		        	 var value="#seat"+seats.length; 
		        	 console.log(value);
		        	 if ($(value).val().length <= 0) {
		                 $(value).val(seat);
		        
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
				seatNumber = selectedSeatNumber[0].id;
				console.log(seatNumber);
				var values=$(this).val();
				console.log(values);
				var index = seats.indexOf($(this).val());
				if (index > -1) {
					seats.splice(index, 1);
				}
				console.log("after pop "+seats);
		 }
	$("#totalseats").val(iter);
	});

/*window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
*/
});

