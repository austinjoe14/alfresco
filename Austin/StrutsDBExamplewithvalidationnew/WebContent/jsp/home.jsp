<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page errorPage="login.jsp" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="session.jsp"></jsp:include>
	<html:link action="/movie">
		<div class="card" id="bookmovie">
			<img src="images/unnamed(1).png" style="width: 100%">
			<div class="container">
				<p>Movie</p>
			</div>
		</div>
	</html:link>
	<html:link action="/bus">
		<div class="card" id="bookbus">
			<img src="images/unnamed.jpg" style="width: 100%">
			<div class="container">
				<p>bus</p>
			</div>
		</div>
	</html:link>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>