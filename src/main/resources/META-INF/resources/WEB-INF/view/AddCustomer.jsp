<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Register Customer</title>
<body>
	<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
    
	<h3>Add House</h3>
	<form method="POST" name="add_customer"
		action="<%=request.getContextPath()%>/add/customer">
		Customer Name: <input name="customer_name" value="${customer_name}" type="text" /> <br /> <br />
		Email: <input name="customer_email" value="${customer_email}" type="text" /><br /> <br />
		Username: <input name="customer_username" value="${customer_username}" type="text" /><br /> <br />
		Password: <input name="customer_password" value="${customer_password}" type="text" /> <br /> <br />
		Phone No: <input name="customer_phone_no" value="${customer_phone_no}" type="text" 
		required maxlength="10" minlength="3" />
		<input value="Register" type="submit" />
	</form>
</body>
</html>