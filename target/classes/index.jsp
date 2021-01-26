<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h2>Log In</h2>
		<form action="${pageContext.request.contextPath}/loginservice"
			method="post">
			User Name:<input type="text" name="userid" /><br /> <br />
			Password:<input type="password" name="password" /><br /> <br /> <input
				type="submit" value="login" />
		</form>
		<h5>*********************************************************</h5>
		<h4>New Here...</h4>
		<a href="/user/registration.jsp">Sign Up</a>
	</div>
</body>
</html>