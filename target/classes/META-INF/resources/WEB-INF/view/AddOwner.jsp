<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Register owner</title>
<body>
	<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add House</h3>
	<form method="POST" name="add_owner"
		action="<%=request.getContextPath()%>/add/owner">
		Owner Name: <input name="owner_name" value="${owner_name}" type="text" /> <br /> <br />
		Email: <input name="owner_email" value="${owner_email}" type="text" /><br /> <br />
		Username: <input name="owner_username" value="${owner_username}" type="text" /><br /> <br />
		Password: <input name="owner_password" value="${owner_password}" type="text" /> <br /> <br />
		Phone No: <input name="owner_phone_no" value="${owner_phone_no}" type="text" 
		required maxlength="10" minlength="3" />
		<input value="Register" type="submit" />
	</form>
</body>
</html>