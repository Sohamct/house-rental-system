<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login </h2>
	<form method = "POST">
	<label for = "username"> Username:</label>
		<input id="username" name="username" type="text" />
	<label for = "username"> Password:</label>
		<input id="password" name="password" type="text" />
		
	<button type = "submit" formaction = "<%=request.getContextPath()%>/loginowner">Login</button>
		
	</form>
</body>
</html>