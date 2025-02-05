<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Configuration</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Configuration</h2>
	<form action="Configuration" method="POST">
		<label for="default">Set your default occupation: </label>
		<input type="text" name="default" id="default" value="${cookie.default_occupation.value.replace('+', ' ')}"> 
		<input type="submit" name="submit" value="Confirm">
	</form>
	<p>You have accessed this page ${configuration_number} times this session.</p>
</body>
</html>