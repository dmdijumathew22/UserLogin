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
		<h2 >Log In</h2>

		${msg}
		<form action="loginservice"
			method="post">
			<table style="with: 50%">
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="login" />
		</form>
		<h5>*********************************************************</h5>
		<h4>New Here...</h4>
		<a href="/user/registration.jsp">Sign Up</a>
	</div>
</body>
</html>