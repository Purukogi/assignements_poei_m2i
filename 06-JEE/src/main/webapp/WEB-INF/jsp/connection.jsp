<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Login page</title>
</head>
<body>
	<header>
	<div>
		<h1>${f:replace(pageContext.request.contextPath,'/', '') } 2025©</h1>		
	</div>
	</header>
	<h2>Login to continue</h2>
	<p>${loginError }</p>
	<div>
		<form action="Connection" method="POST">
			<fieldset>
				<legend>Login information:</legend>
				<div>
					<label for="username">Username: </label>
					<input type="text" name="username" id="username">
				</div>
				<div>
					<label for="password">Password: </label>
					<input type="password" name="password" id="password">
				</div>
				<label for="remember">Remember me: </label>
				<input type="checkbox" name="remember" id="remember">
				<input type="submit" name="submit" value="Connection">				
			</fieldset>
		</form>
	</div>
	<a href="Register">Register</a>
</body>
</html>