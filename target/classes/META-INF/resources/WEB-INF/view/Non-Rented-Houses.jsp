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

	<form method = "POST">
	
	<c:choose>
		<c:when test="${houses != null}">
			<h3>List of Houses Owned By You</h3>
			
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>House Id</th>
						<th>House Address</th>
						<th>House City</th>
						<th>House Rent</th>
						<th>House Information</th>
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

							<td>
							<a href="<%=request.getContextPath()%>/delete/${h.getHouse_id()}/house/${owner_id}" 
							onclick="return confirm('Do you really want to delete?')">Delete</a></td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		</c:choose>
		<button formaction = "Home">Back </button>
	</form>
</body>
</html>