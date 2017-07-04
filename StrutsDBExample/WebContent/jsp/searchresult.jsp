<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<title>Insert title here</title>
</head>
<body bgcolor="silver">
	<jsp:include page="header.jsp"></jsp:include>
	<table border="1">
		<tr>
			<td align="center">Id</td>
			<td align="center">Name</td>
			<td align="center">Delete</td>
			<td align="center">Download</td>
			<td align="center">Multiple Download</td>
		</tr>
		<logic:iterate id="fileName" property="file" name="loginForm">
			<tr>
				<td><bean:write name="fileName" property="fileId" /></td>
				<td><bean:write name="fileName" property="fileNames" /></td>
				<td><input type="radio" name="deleteinfo"></td>
				<td><input type="radio" name="downloadfile"></td>
				<td><input type="checkbox" name="downloadmultifile"></td>
			</tr>
		</logic:iterate>
	</table>
<%-- 	<html:form action="deletezip" styleId="downloadmultifile">
	
	</html:form> --%>
	<html:form action="delete" styleId="deleteinfo">
		<table border="1">
			<tr>
				<td>Document Name</td>
				<td><html:text property="fileNames" readonly="true" /></td>
				<td><input type="hidden" name="fileId" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="delete" />
	</html:form>
	<html:form action="download" styleId="downloadfile">
		<table border="1">
			<tr>
				<td>Document Name</td>
				<td>File Name<html:text property="fileNames" readonly="true" /></td>
				<td><input type="hidden" name="fileId" /></td>
				<td>New File Name<input type="text" name="newFileName"
					required="required" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="download" />
	</html:form>
</body>
</html>