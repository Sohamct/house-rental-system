<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>

	<c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>
	<form method="POST" action = "<%=request.getContextPath()%>/logincustomer">
		<label for="customer_username">		Username:	</label> 
		<input id="customer_username" name="customer_username" type="text" /> 
		<label for="customer_password">		Password:	</label> 
		<input id="customer_password" name="customer_password" type="text" />

		<button type="submit" value = "submit">Login</button>

	</form>
</body>
</html>