<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes</title>
</head>
<body>
	<div id="loginForm" class="cls-loginForm" align="center">
		<form action="loginProcess" method="post">
			<label for="emailid"> Enter EmailID </label>
			<input type="email" id="email" name="email"> <br>
			<label for="pass"> Enter Password </label>
			<input type="password" id="pass" name="pass"> <br>
			<input type="submit" value="submit"> <br>
		</form>
	</div>
</body>
</html>