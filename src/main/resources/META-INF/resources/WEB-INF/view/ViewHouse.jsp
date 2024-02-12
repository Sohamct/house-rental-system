<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>House Details</title>
<body>
	<h2>House Details</h2>
	House Id : ${house.getHouse_id()}
	<br /> House Address : ${house.getHouse_address()}
	<br /> City : ${house.getCity()}
	<br /> House Rent : ${house.getRent()}
	<br /> House Information : ${house.getHouse_info()}
</body>
</html>