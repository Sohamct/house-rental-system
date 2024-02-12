<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>House-Rental-System</title>
<body>
	<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
	<a href="<%=request.getContextPath()%>/addCustomer">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${customers != null}">
			<h3>List of Customers</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>Customer Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${customers}">
						<tr>
							<td>${c.customer_id}</td>
							<td>${c.customer_name}</td>
							<td>${c.customer_email}</td>
							<td>${c.customer_phone_no}</td>
							<td><a
								href="<%=request.getContextPath()%>/customer/${c.customer_id}">Details</a>
								&nbsp;
								&nbsp; 
								<!-- <a
								href="<%=request.getContextPath()%>/delete/customer/${c.customer_id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No Customer found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>