<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div align="center">
	<h2>User Registration</h2>
		<form action="${pageContext.request.contextPath}/RegisterService"
			method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="text" name="email" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
		<h5>*********************************************************</h5>
		${msg}
		<h4>Already have an account?</h4>
		<a href="/user/index.jsp">Log In Here</a>
	</div>
</body>
</html>