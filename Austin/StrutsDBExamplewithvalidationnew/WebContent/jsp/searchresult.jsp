<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/simple.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="session.jsp"></jsp:include>
	Date is <%=session.getAttribute("tdate") %>
	<div id="list">
		<table class="table">
			<tr>
				<th>Bus Id</th>
				<th>Bus Name</th>
				<th>Bus Number </th>
				<th>Seats available</th>
				<th>Bus Type</th>
				<th>Book</th>
			</tr>
			<logic:iterate id="data" name="BusForm" property="list" >
				<tr>
					<td><bean:write name="data" property="busId"/></td>
					<td><bean:write name="data" property="busName" /></td>
					<td><bean:write name="data" property="busNumber" /></td>
					<td><bean:write name="data" property="seats" /></td>
					<td><bean:write name="data" property="busType" /></td>
					<%-- <td><html:link action="/selectseat" styleClass="submits" styleId="addbusbtn">view seats</html:link></td> --%>
					<td><input type="radio" name="viewBus" ></td>
				</tr>
			</logic:iterate>
			<tr>
				<td><html:link action="/booking" styleClass="submits" styleId="addbusbtn">modify</html:link></td>
			</tr>
		</table>
		<html:form action="selectseat" styleId="viewSelectedBusForBookingform">

		<table border="1" cellpadding="5" class="seats">
		<tr class="seats">
				<td>Bus Name</td>
				<td><html:text property="busName" readonly="true" /></td>
			</tr>
			<tr class="seats">
				<td>Bus Number</td>
				<td><html:text property="busNumber" readonly="true" /></td>
			</tr>
		</table>
		<input type="submit" value="View seats"  />
	</html:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>