<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body bgcolor="silver">
<br></br>
<body>
    <div style="color:red">
    <html:errors />
    </div>
    <html:form action="/login" >
        <bean:message key="label.user.username" /> :  <html:text property="username" />
		<br />
        <bean:message key="label.user.password" /> :  <html:password property="password" />
		<br />
		<html:submit value="Login" />
	</html:form>
	<html:form action="/register.jsp">
	<html:submit>Register</html:submit>
	</html:form>
	
</body>
</html>
