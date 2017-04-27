<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="login.jsp" %>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div style="color: red">
		<html:errors />
</div>
<div class="header" >
		<h1>Bus and Movie Ticket Booking</h1>
		<html:link action="/logout" styleClass="submits" styleId="logout">Logout</html:link>
</div>
<hr id="loginhr">
</body>
</html>