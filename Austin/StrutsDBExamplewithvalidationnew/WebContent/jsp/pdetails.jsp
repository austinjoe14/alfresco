<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entering passenger details</title>
</head>
<body>
	giuiu
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="session.jsp"></jsp:include>
	
	<html:form action="/confirmseat">
	<%
		int counter = (Integer) session.getAttribute("totalseats");
		for (int counterOne = 1; counterOne <= counter; counterOne++) {
	%>
		<label>passenger details form for passenger <%=counterOne%></label>
		<br>
		<label>Enter passenger name</label>
		<input type="text" name="userName<%=counterOne%>" />
		<br>
		<label>Enter passenger age</label>
		<input type="text" name="age<%=counterOne%>" />
		<br>
		<label>Choose Gender</label>
		<select name="gender<%=counterOne%>">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
		</select>
		<br>
		<label>Contact</label>
		<input type="text" name="contact<%=counterOne%>" />
		<br>
		<%
			}
		%>
		<html:submit value="submit" styleClass="submits"></html:submit>
	</html:form>

</body>
</html>