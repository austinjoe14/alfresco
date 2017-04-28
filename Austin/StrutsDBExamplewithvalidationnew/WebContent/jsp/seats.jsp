<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
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
	<h1>Select your seat</h1>
	<!-- SquaredONE -->
	<%
		ArrayList<Integer> countFemale = (ArrayList) request.getAttribute("female");
		Iterator<Integer> itr = countFemale.iterator();
		while (itr.hasNext()) {
			int element = itr.next();
			out.println(element);
		}
	%>

	<html:form styleId="getseat">
		<%
			ArrayList<Integer> countMale = (ArrayList) request.getAttribute("male");
				itr = countMale.iterator();
				while (itr.hasNext()) {
					int element = itr.next();
		%>
		<html:hidden property="seats" value="<%=element%>" ></html:hidden>
		<%
				}
		%>
	</html:form>

	<html:form styleId="chooseseats">
		<table id="test">
			<tr class="seats">
				<td id="seats"><div class="asiento">
						<input type="checkbox" value="1" id="1" name="check" /> <label>1w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="3" id="3" name="check" /> <label>3w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="5" id="5" name="check" /> <label>5w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="7" id="7" name="check" /> <label>7w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="9" id="9" name="check" /> <label>9w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="11" id="11" name="check" /> <label>11w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="13" id="13" name="check" /> <label>13w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="15" id="15" name="check" /> <label>15w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="17" id="17" name="check" /> <label>17w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="19" id="19" name="check" /> <label>19w</label>
					</div></td>
				<td id="seats"><div class="asiento">
						<input type="checkbox" value="2" id="2" name="check" /> <label>2</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="4" id="4" name="check" /> <label>4</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="6" id="6" name="check" /> <label>6</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="8" id="8" name="check" /> <label>8</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="10" id="10" name="check" /> <label>10</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="12" id="12" name="check" /> <label>12</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="14" id="14" name="check" /> <label>14</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="16" id="16" name="check" /> <label>16</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="18" id="18" name="check" /> <label>18</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="20" id="20" name="check" /> <label>20</label>
					</div></td>
				<td id="seats"><div class="asiento">
						<input type="checkbox" value="21" id="21" name="check" /> <label>21</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="23" id="23" name="check" /> <label>23</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="25" id="25" name="check" /> <label>25</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="27" id="27" name="check" /> <label>27</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="29" id="29" name="check" /> <label>29</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="31" id="31" name="check" /> <label>31</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="33" id="33" name="check" /> <label>33</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="35" id="35" name="check" /> <label>35</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="37" id="37" name="check" /> <label>37</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="39" id="39" name="check" /> <label>39</label>
					</div></td>
				<td id="seats"><div class="asiento">
						<input type="checkbox" value="22" id="22" name="check" /> <label>22w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="24" id="24" name="check" /> <label>24w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="26" id="26" name="check" /> <label>26w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="28" id="28" name="check" /> <label>28w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="30" id="30" name="check" /> <label>30w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="32" id="32" name="check" /> <label>32w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="34" id="34" name="check" /> <label>34w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="36" id="36" name="check" /> <label>36w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="38" id="38" name="check" /> <label>38w</label>
					</div>
					<div class="asiento">
						<input type="checkbox" value="40" id="40" name="check" /> <label>40w</label>
					</div></td>
			</tr>
		</table>
		<button type="button">Book</button>
	</html:form>
	<%-- <html:form styleId="display" action="/confirmseat" method="post"> --%>
	<html:form styleId="display" action="/passenger" method="post">
	Total Seats<html:text property="totalseats" styleId="totalseats" />
	Seats Booked are
		<table>
			<tr id="seatno"></tr>
		</table>
		<html:submit>submit</html:submit>
	</html:form>

	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>