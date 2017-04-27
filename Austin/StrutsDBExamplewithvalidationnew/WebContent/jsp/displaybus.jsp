<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	<%@ page errorPage="login.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="session.jsp"></jsp:include>
	<div id="list">
		<table class="table">
			<tr>
				<th>Bus Id</th>
				<th>Bus Name</th>
				<th>Bus Type</th>
				<th>Seats available</th>
				<th>Bus Number</th>
			</tr>
			<logic:iterate id="data" name="BusForm" property="list" >
				<tr>
					<td><bean:write name="data" property="busId"/></td>
					<td><bean:write name="data" property="busName" /></td>
					<td><bean:write name="data" property="busType" /></td>
					<td><bean:write name="data" property="seats" /></td>
					<td><bean:write name="data" property="busNumber" /></td>
				</tr>
			</logic:iterate>
			<tr>
					<td><html:link action="/addbuspage" styleClass="submits" styleId="addbusbtn">add bus</html:link></td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>