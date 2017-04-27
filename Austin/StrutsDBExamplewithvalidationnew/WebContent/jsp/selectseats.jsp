<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Choose seats by clicking the corresponding seat in the layout
		below:</h2>
	<div id="holder">
		<ul id="place">
		</ul>
	</div>
	<div style="float: left;">
		<ul id="seatDescription">
			<li
				style="background: url('images/available_seat_img.gif') no-repeat scroll 0 0 transparent;">Available
				Seat</li>
			<li
				style="background: url('images/booked_seat_img.gif') no-repeat scroll 0 0 transparent;">Booked
				Seat</li>
			<li
				style="background: url('images/selected_seat_img.gif') no-repeat scroll 0 0 transparent;">Selected
				Seat</li>
			<li
				style="background: url('images/ladies_seat_img.gif') no-repeat scroll 0 0 transparent;">ladies
				Seat</li>
		</ul>
	</div>
	<div style="clear: both; width: 100%">
		<input type="button" id="btnShowNew" value="Show Selected Seats" /> <input
			type="button" id="btnShow" value="Show All" />
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>