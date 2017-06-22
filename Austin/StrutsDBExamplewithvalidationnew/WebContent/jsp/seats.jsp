<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/simple.js"></script>
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="totalSeats" value=<%=request.getAttribute("totalseats") %> />

	<h1>Select your seat</h1>
	<!-- SquaredONE -->
	<p>
		Female Seats
		<button id="femaleSeat"></button>
	</p>
	<p>
		Unavailable
		<button id="Unavailable"></button>
	</p>
	<form>
		<input type="hidden" name="totalSeats" value=<%=request.getAttribute("totalseats") %> />
		<%=request.getAttribute("female")%>
		<%=request.getAttribute("male")%>
		<%
			int iter = 0;
		%>
		<c:forEach items="${female}" var="bean">

			<input type="hidden" name="seatss<%=iter%>"
				value="<c:out value="${bean}" />">
			<input type="hidden" name="females<%=iter%>"
				value="<c:out value="${bean}" />">
			<%
				iter++;
			%>

		</c:forEach>
		<c:forEach items="${male}" var="bean">

			<input type="hidden" name="seatss<%=iter%>"
				value="<c:out value="${bean}" />">

			<%
				iter++;
			%>

		</c:forEach>
	</form>

	<html:form styleId="chooseseats">
		<table id="test">
			<tr class="seats" id="seats">
				<td class="asiento" id="1"><input type="checkbox" value="1"
					id="1" name="check" /> <label>1w</label></td>
				<td class="asiento" id="3"><input type="checkbox" value="3"
					id="3" name="check" /> <label>3w</label></td>
				<td class="asiento" id="5"><input type="checkbox" value="5"
					id="5" name="check" /> <label>5w</label></td>
				<td class="asiento" id="7"><input type="checkbox" value="7"
					id="7" name="check" /> <label>7w</label></td>
				<td class="asiento" id="9"><input type="checkbox" value="9"
					id="9" name="check" /> <label>9w</label></td>
				<td class="asiento" id="11"><input type="checkbox" value="11"
					id="11" name="check" /> <label>11w</label></td>
				<td class="asiento" id="13"><input type="checkbox" value="13"
					id="13" name="check" /> <label>13w</label></td>
				<td class="asiento" id="15"><input type="checkbox" value="15"
					id="15" name="check" /> <label>15w</label></td>
				<td class="asiento" id="17"><input type="checkbox" value="17"
					id="17" name="check" /> <label>17w</label></td>
				<td class="asiento" id="19"><input type="checkbox" value="19"
					id="19" name="check" /> <label>19w</label></td>
			</tr>
			<tr class="seats" id="seats">
				<td class="asiento" id="2"><input type="checkbox" value="2"
					id="2" name="check" /> <label>2</label></td>
				<td class="asiento" id="4"><input type="checkbox" value="4"
					id="4" name="check" /> <label>4</label></td>
				<td class="asiento" id="6"><input type="checkbox" value="6"
					id="6" name="check" /> <label>6</label></td>
				<td class="asiento" id="8"><input type="checkbox" value="8"
					id="8" name="check" /> <label>8</label></td>
				<td class="asiento" id="10"><input type="checkbox" value="10"
					id="10" name="check" /> <label>10</label></td>
				<td class="asiento" id="12"><input type="checkbox" value="12"
					id="12" name="check" /> <label>12</label></td>
				<td class="asiento" id="14"><input type="checkbox" value="14"
					id="14" name="check" /> <label>14</label></td>
				<td class="asiento" id="16"><input type="checkbox" value="16"
					id="16" name="check" /> <label>16</label></td>
				<td class="asiento" id="18"><input type="checkbox" value="18"
					id="18" name="check" /> <label>18</label></td>
				<td class="asiento" id="20"><input type="checkbox" value="20"
					id="20" name="check" /> <label>20</label></td>
			</tr>
			<tr class="seats" id="seats">
				<td class="asiento" id="21"><input type="checkbox" value="21"
					id="21" name="check" /> <label>21</label></td>
				<td class="asiento" id="23"><input type="checkbox" value="23"
					id="23" name="check" /> <label>23</label></td>
				<td class="asiento" id="25"><input type="checkbox" value="25"
					id="25" name="check" /> <label>25</label></td>
				<td class="asiento" id="27"><input type="checkbox" value="27"
					id="27" name="check" /> <label>27</label></td>
				<td class="asiento" id="29"><input type="checkbox" value="29"
					id="29" name="check" /> <label>29</label></td>
				<td class="asiento" id="31"><input type="checkbox" value="31"
					id="31" name="check" /> <label>31</label></td>
				<td class="asiento" id="33"><input type="checkbox" value="33"
					id="33" name="check" /> <label>33</label></td>
				<td class="asiento" id="35"><input type="checkbox" value="35"
					id="35" name="check" /> <label>35</label></td>
				<td class="asiento" id="37"><input type="checkbox" value="37"
					id="37" name="check" /> <label>37</label></td>
				<td class="asiento" id="39"><input type="checkbox" value="39"
					id="39" name="check" /> <label>39</label></td>
			</tr>
			<tr class="seats" id="seats">
				<td class="asiento" id="22"><input type="checkbox" value="22"
					id="22" name="check" /> <label>22w</label></td>
				<td class="asiento" id="24"><input type="checkbox" value="24"
					id="24" name="check" /> <label>24w</label></td>
				<td class="asiento" id="26"><input type="checkbox" value="26"
					id="26" name="check" /> <label>26w</label></td>
				<td class="asiento" id="28"><input type="checkbox" value="28"
					id="28" name="check" /> <label>28w</label></td>
				<td class="asiento" id="30"><input type="checkbox" value="30"
					id="30" name="check" /> <label>30w</label></td>
				<td class="asiento" id="32"><input type="checkbox" value="32"
					id="32" name="check" /> <label>32w</label></td>
				<td class="asiento" id="34"><input type="checkbox" value="34"
					id="34" name="check" /> <label>34w</label></td>
				<td class="asiento" id="36"><input type="checkbox" value="36"
					id="36" name="check" /> <label>36w</label></td>
				<td class="asiento" id="38"><input type="checkbox" value="38"
					id="38" name="check" /> <label>38w</label></td>
				<td class="asiento" id="40"><input type="checkbox" value="40"
					id="40" name="check" /> <label>40w</label></td>
			</tr>
		</table>
	</html:form>
	
	<html:form styleId="display" action="/passenger" method="post">
	Total Seats<html:text property="totalseats" styleId="totalseats" />
		<table>
			<tr id="seatno"></tr>
		</table>
		<html:submit>submit</html:submit>
	</html:form>

	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>