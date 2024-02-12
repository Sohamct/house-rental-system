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
		<c:when test="${r_h != null}">
			<h3>List of Houses Owned By You</h3>
			
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>House Id</th>
						<th>House Address</th>
						<th>House City</th>
						<th>House Rent</th>
						<th>House Information</th>
						
						<th></th>
						
						<th>Owner name</th>
						<th>Owner Email</th>
						<th>Owner Phone No</th>
	
					</tr>
				</thead>
				<tbody>
					<c:forEach var="h" items="${r_h}" var = "o" items="${owner}">
						<tr>
							<td>${h.getHouse_id()}</td>
							<td>${h.getHouse_address()}</td>
							<td>${h.getCity()}</td>
							<td>${h.getRent()}</td>
							<td>${h.getHouse_info()}</td>
							
							<td></td>
							<td>${o.getOwner_name()}</td>
							<td>${h.getOwner_email()}</td>
							<td>${h.getOwner_phone_no()}</td>

							<td>
							<a href="<%=request.getContextPath()%>/remove-rented/${h.getHouse_id()}/house/${sessionScope.id}" 
							onclick="return confirm('Do you really want to remove this rented house?')"> Remove</a></td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        <h3>You Have Not Rented Any House</h3> 
        </c:otherwise>
		</c:choose>
		<button formaction = "<%=request.getContextPath()%>/home">Back </button>
	</form>
</body>
</html>