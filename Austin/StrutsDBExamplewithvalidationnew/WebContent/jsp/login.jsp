<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body bgcolor="silver">
	<br></br>
<body>
	<div style="color: red">
		<html:errors />
	</div>
	<div class="validation-grids">
	<html:form action="/login">
        Username : <html:text property="username" />
		<br />
		<br />
        Password : <html:password property="password" />
		<br />
		<br />
		<html:submit value="Login" />
		<html:link action="/register.jsp" styleClass="button">register</html:link>
	</html:form>
	
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
