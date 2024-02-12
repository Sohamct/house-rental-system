<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Add House</title>
<body>
        <h3>${msg} </h3>
    
    
    	<h3>Add New House</h3>
	<form method="POST"
		action="<%=request.getContextPath()%>/addHouse/${owner_id}">
		House Address: <input name="house_address" value="${house_address}" type="text" /> <br /> <br />
		House City: <input name="house_city" value="${house_city}" type="text" />
		<br /> <br />
		House Rent: <input name="house_rent" value="${house_rent}" type="number" /> <br /> <br />
		House Information: <input name="house_info" value="${house_info}" type="text" 
		required maxlength="100" /><br /> <br />
		<input value="Add House" type="submit" />
	</form>
</body>
</html>