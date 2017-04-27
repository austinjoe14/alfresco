<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="session.jsp"></jsp:include>
	<div id="list">
		<table class="table">
			<tr>
				<th>click</th>
				<th>Bus Id</th>
				<th>Bus Name</th>
				<th>Bus Type</th>
				<th>Seats available</th>
				<th>Bus Number</th>
			</tr>
			<logic:iterate id="data" name="BusForm" property="list">
				<tr><td class="center"><input type="radio" name="updateradio"
							id="rdo" required /></td>
					<td><bean:write name="data" property="busId"/></td>
					<td><bean:write name="data" property="busName" /></td>
					<td><bean:write name="data" property="busType" /></td>
					<td><bean:write name="data" property="seats" /></td>
					<td><bean:write name="data" property="busNumber" /></td>
					<%-- <td><html:form action="/editbusaction"><html:submit styleClass="submits">edits</html:submit> </html:form> </td> --%>
				</tr>
			</logic:iterate>
		</table>
	</div>
	<div id="delete" class="table" align="center">
		<html:form action="deletebusaction" >
			<h3>Bus Details:</h3>
			<table border="1" cellpadding="5">
				<tr>
					<td>Bus ID</td>
					<td><html:text property="busId" readonly="true" /></td>
				</tr>
				<tr>
					<td>Bus Name</td>
					<td><html:text property="busName" readonly="true"/></td>
				</tr>
				<tr>
					<td>Bus Number</td>
					<td><html:text property="busNumber" readonly="true"/></td>
				</tr>
				<tr>
					<td>seats</td>
					<td><html:text property="seats" readonly="true"/></td>
				</tr>
				<tr>
					<td>Bus Type</td>
					<td><html:text property="busType" readonly="true"/></td>
				</tr>
			</table>
			<input type="submit" value="delete" class="submits" />
		</html:form>
	</div>
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>