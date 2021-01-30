<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<div align = "center">
<h3>Welcome</h3><br>
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td> ${first_name} ${last_name}</td>
				</tr>
				
				<tr>
					<td>UserName</td>
					<td>${userid}</td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td>${email}</td>
				</tr>
			</table>
			<a href="index.jsp"><input type="submit" value="Log Out" /></a>
	</div>
</body>
</html>