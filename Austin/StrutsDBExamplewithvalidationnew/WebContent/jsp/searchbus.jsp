<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/simple.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="userhome.jsp"></jsp:include>
<%
   Date dNow = new Date( );
   SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd");
   out.print( "<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
%>
	<html:form action="book">
	 source : <html:text property="startingPoint" />
		<br />
		<br />
        destination : <html:text property="endPoint" />
		<br />
		<br />
		select date
		<td><input type="date" name="date" required class="min-today" id="min" data-date-split-input="true"/></td> 
		<%-- <html:text property="date" ></html:text> --%>
		<html:submit value="book" />
	</html:form>
</body>
</html>