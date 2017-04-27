<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="login.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
	<jsp:include page="session.jsp"></jsp:include>
	<div id="newBusForm" class="menuview">
		<html:html>
		<html:form action="addbus" method="post">
		Enter your Bus Name:
		<html:text property="busName" size="50" />
			<br>
		choose bus type:
			<html:select property="busType">
				<html:option value="0">Select Type</html:option>
				<html:option value="AC Sleeper">AC Sleeper</html:option>
				<html:option value="Non AC Sleeper">Non AC Sleeper</html:option>
				<html:option value="AC Seater">AC Seater</html:option>
				<html:option value="Non AC Seater">Non AC Seater</html:option>
			</html:select>
			<br>
		Enter Bus Number:
		<html:text property="busNumber" size="50" />
			<br>
		Enter Route:
		<html:text property="route" size="50" />
			<br>
		choose Day:
			<html:select property="day">
				<html:option value="0" disabled="true">Select Type</html:option>
				<html:option value="Monday">Monday</html:option>
				<html:option value="Tuesday">Tuesday</html:option>
				<html:option value="Wednesday">Wednesday</html:option>
				<html:option value="Thursday">Thursday</html:option>
				<html:option value="Friday">Friday</html:option>
				<html:option value="Saturday">Saturday</html:option>
				<html:option value="Sunday">Sunday</html:option>
			</html:select>
			<br>
			choose type:
			<html:select property="type">
				<html:option value="source">source</html:option>
				<html:option value="pickup">pick up</html:option>
				<html:option value="drop">drop</html:option>
			</html:select>
			<br>
			Enter time:
		<input type="time" name="bustime" placeholder="hrs:mins" pattern="^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$" required="required"/>
			<br>
			<html:submit>Submit</html:submit>
			<br>
		</html:form>
		</html:html>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>