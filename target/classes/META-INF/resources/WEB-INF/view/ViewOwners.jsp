<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
	<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
	<a href="<%=request.getContextPath()%>/addOwner">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${owners != null}">
			<h3>List of owners</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>Owner Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="o" items="${owners}">
						<tr>
							<td>${o.owner_id}</td>
							<td>${o.owner_name}</td>
							<td>${o.owner_email}</td>
							<td>${o.owner_phone_no}</td>
							<td><a
								href="<%=request.getContextPath()%>/Owner/${o.owner_id}">Details</a>
								&nbsp;
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/Owner/${o.owner_id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No Owner found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>