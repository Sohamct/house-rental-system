<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome ${sessionScope.username} To House Rental Web Application</h1>
	<form method = "POST">
	
<!-- 	<div >
		<input class="form-check-input" type="radio" name="userType"
			value = "Admin" id="Admin"> <label class="form-check-label"
			for="Admin"> Admin </label>
	</div> -->
	
	<c:if test = "${sessionScope.username == null}">
	<h2>Select User Type:</h2>
	<div class="form-check">
		<input class="form-check-input" type="radio" value = "Owner" name="userType"
			id="Owner"> <label
			class="form-check-label" for="Owner"> Owner </label>
	</div>
		<div class="form-check">
		<input class="form-check-input" type="radio" name="userType" value = "Customer"
			id="Customer" checked> <label
			class="form-check-label" for="Customer"> Customer </label>
	</div>
	</c:if>
	<br>
	<c:if test = "${sessionScope.username != null}">
	<c:if test = "${sessionScope.usertype == 'Customer'}">
		<h2>All Available Houses </h2>
		<c:choose>
		<c:when test="${houses != null}">
			<h3>List of House</h3>
			<table cellpadding="5" cellspacing="5">
				<h3>${msg}</h3>
				<thead>
					<tr>
						<th>House Id</th>
						<th>House Address</th>
						<th>House City</th>
						<th>House Rent</th>
						<th>House Information</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="h" items="${houses}">
						<tr>
							<td>${h.getHouse_id()}</td>
							<td>${h.getHouse_address()}</td>
							<td>${h.getCity()}</td>
							<td>${h.getRent()}</td>
							<td>${h.getHouse_info()}</td>
							<td><a
								href="<%=request.getContextPath()%>/house/${h.getHouse_id()}">Details</a>
								&nbsp;
								&nbsp; 
								<a
								href="<%=request.getContextPath()%>/rent/${h.getHouse_id()}/house/${sessionScope.id}"
								onclick="return confirm('Do you really want to rent this house?')">Buy This House</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button value = "View Rented House By Me" formaction = "<%=request.getContextPath()%>/view-rented-house/c/${sessionScope.id}">View Rented House By Me</button>
		</c:when>
		<c:otherwise>
        No House found in the DB!
        </c:otherwise>
        
	</c:choose>
	</c:if>
	</c:if>
	
	<c:if test = "${sessionScope.username != null}">
	<c:if test = "${sessionScope.usertype == 'Owner'}">
	
		<a href="<%=request.getContextPath()%>/add/house/${sessionScope.id}">Add House</a><br> <br/>

		<a href="<%=request.getContextPath()%>/non_rented/house/${sessionScope.id}">Show My NonRented Houses</a>   <br><br/>
	
		<a href="<%=request.getContextPath()%>/view-rented-house/c/${sessionScope.id}">Show My Rented Houses </a> <br><br/>
	</c:if>
	</c:if>
	
	
	<c:if test="${sessionScope.username != null}">
	<button type = "submit" formaction="<%=request.getContextPath()%>/logout">Logout</button>
	</c:if>
	<c:if test = "${sessionScope.username == null}">
	<button type = "submit" formaction="<%=request.getContextPath()%>/L">Login</button>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<button type = "submit" formaction="<%=request.getContextPath()%>/R">Register</button>	
	</c:if>
	</form>
</body>
</html>