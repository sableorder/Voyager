<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Cabin|Roboto' rel='stylesheet' type='text/css'/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css"/>
<title>Login</title>
</head>
<body>
	<h1>Register</h1>
	<form method="post">
		<label>Username:</label>
		<input type="text" name="username"/>
		<label>Password:</label>
		<input type="password" name="password"/>
		<label>Confirm Password:</label>
		<input name="confirmPassword" type="password"/>
		<input type="submit" value ="Register" id="submit"/>
	</form>
	
</body>
</html>