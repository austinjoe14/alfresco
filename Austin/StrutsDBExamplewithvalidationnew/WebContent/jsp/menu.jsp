<%@page import="org.apache.jasper.tagplugins.jstl.core.Choose"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
			try {
				int role = (Integer) session.getAttribute("role");
				if (role == 2) {
					response.sendRedirect("jsp/login.jsp");
				} else {
		%>
		<html:link action="/addbuspage" styleClass="menu">add bus</html:link>
		<html:link action="/editbus" styleClass="menu">edit bus</html:link>
		<html:link action="/displayingbus" styleClass="menu">display bus</html:link>
		<html:link action="/deletebus" styleClass="menu">delete bus</html:link>
		<%
			}
			} catch (NullPointerException exception) {
				response.sendRedirect("jsp/login.jsp");
			}
		%>
	</div>
</body>
</html>