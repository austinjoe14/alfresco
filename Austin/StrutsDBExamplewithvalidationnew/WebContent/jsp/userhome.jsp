<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Anywhere</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	welcome user
	<jsp:include page="header.jsp"></jsp:include>
	<html:link action="/booking" styleClass="menu">book</html:link>
	<html:link action="/cancel" styleClass="menu">cancel tickets</html:link>
	<html:link action="/status" styleClass="menu">ticket status</html:link>
	<html:link action="/details" styleClass="menu">User Details</html:link>
</body>
</html>