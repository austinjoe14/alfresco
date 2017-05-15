$(document).ready(function() {
	$("#femaleSeatIdentifier").css('background-color', 'brown');
	$("#UnavailableSeatIdentifier").css('background-color', 'grey');
	i=0;
	var existSeat=new Array();
	$("input[type='checkbox']").attr('checked', false);
	
	console.log($("input[type='hidden'] ").val());
	var Seats=$("input[type='hidden'] ").val(); //Total number of seats already booked
	
	var females=$("input[type='hidden'][name='']").val();
	
	//for loop to get seats names
	for(iter=0;iter<Seats;iter++){		
			var value = "seatss" + iter;
			console.log(value);
			existSeat[i] = $("input[type='hidden'][name='" + value + "']").val();
			coloringseat="#"+existSeat[i];
			$(coloringseat).css('background-color', 'grey');
			i++;
			
			var valuess = "females" + iter;
			var fs=$("input[type='hidden'][name='" + valuess + "']").val();
			console.log("FEMALEEEEEEEE"+fs);
			var coloringFemaleSeats="#"+fs;
			$(coloringFemaleSeats).css('background-color', 'brown');
			    
	}
	console.log("existSeat"+i);
	for(var iter1=0;iter1<i;iter1++){
		console.log(existSeat[iter1]);
	}
	console.log("existSeat after");
	
	var seats=new Array();
	var noofSeats=0;
	var myform = $('#myform');
	iter = 0;

	$("input[type='checkbox']").change(function () {
		
		 if($(this).is(":checked")) {
			 j=0;
			 var selectedSeatNumber = $(this).closest("td");
			 seatNumber = selectedSeatNumber.context.id;
			 /* console.log(selectedSeatNumber);
		  	 console.log(seatNumber); */ 
			 console.log("i:"+Seats);
			 for(var iter1=0;iter1<Seats;iter1++){
				console.log("seat:"	+ existSeat[iter1]);
				if (seatNumber == existSeat[iter1]) {
					alert(existSeat[iter1]+" is Already booked\nAlready booked seats are\n"+existSeat);
					$(this).attr('checked', false);
			  }
		     }
			 if($(this).is(":checked")){
			 myform.find('tr').each(function(){
	         var trow = $(this);
	         console.log("this"+this);
	         if(trow.index() === 0){
	             trow.append('<td></td><br>');
	         }else{
	             trow.append('<td><input type="text" id="'+seatNumber+'s" name="'+seatNumber+'s"/></td><br>');
	             var value="#"+seatNumber+"s";
	             /*console.log(value);*/
	             $(value).val(seatNumber);
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
			console.log(selectedSeatNumber);
			seatNumber = selectedSeatNumber.context.id;
			console.log("seatNumber");
			console.log(seatNumber);
			
			var values="#"+seatNumber+"s";
	        var vv= $(values).val();
	          
			$(values).remove();
			console.log(selectedSeatNumber);
			console.log(seatNumber);  
			console.log(iter); 
			console.log(values);
			console.log(vv);
		
		 }
		 $("#noofseatselectedbyuser").val(iter);
		 seats[noofSeats++]=seatNumber;
		 for (i = 0; i < noofSeats; i++) { 
			 console.log("seat "+i);
			 console.log(seats[i]);
		 }
		
	})
	
	
});