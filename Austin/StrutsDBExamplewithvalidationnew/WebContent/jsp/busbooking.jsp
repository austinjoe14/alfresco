<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<title>Travel Anywhere</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
</head>
<body>
	bus booking
	<div>
		<html:form>
	 	Source : <html:text property="Source" />
			<br />
			<br />
        Destination : <html:password property="Destination" />
			<br />
			<br />
			<html:submit value="book" />
			<html:link action="/register.jsp" styleClass="button">register</html:link>
		</html:form>
	</div>
</body>
</html>