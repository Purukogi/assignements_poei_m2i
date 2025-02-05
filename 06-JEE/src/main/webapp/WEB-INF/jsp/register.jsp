<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Register Page</title>
</head>
<body>
	<header>
	<div>
		<h1>${f:replace(pageContext.request.contextPath,'/', '') } 2025©</h1>		
	</div>
	</header>
	<h2>Create your account</h2>
	<div>
		<form action="Register" method="POST">
			<fieldset>
				<legend>Account information:</legend>
				<div>
					<label for="username">Username: </label>
					<input type="text" name="username" id="username">
				</div>
				<div>
					<label for="password">Password: </label>
					<input type="password" name="password" id="password">
				</div>
				<input type="submit" name="submit" value="Register">				
			</fieldset>
		</form>
	</div>
	<a href="Connection">Return to connection page</a>
</body>
</html>