<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>${contact.firstName} ${contact.name}</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Contact Page</h2>
	<fieldset>
	<legend>Contact info:</legend>
		<p>${contact.id} - ${contact.firstName} ${contact.name}</p>
		<p>Born on ${contact.birthday}</p>
		<p>Phone number : ${contact.phoneNumber}</p>
		<p>Socials : ${contact.socials}</p>
		<p>Occupation : ${contact.occupation}</p>
		<p>Specialty : ${contact.specialty}</p>
		<p>Address : ${contact.address.number} ${contact.address.street}, ${contact.address.zipCode} ${contact.address.city}</p>
	</fieldset>
	<form action="DropContact" method="GET">
		<input type="hidden" name="contact_id" value="${contact.id}">
		<input type="submit" name="submit" value="Delete Contact">
	</form>
	<form action="ModifyContact" method="GET">
		<input type="hidden" name="contact_id" value="${contact.id}">
		<input type="submit" name="submit" value="Modifiy Contact">
	</form>
</body>
</html>