<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>ConnectedIn</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Welcome to ConnectedIN</h2>
	<div>
		<h3>List of contacts</h3>
		<div>
			<form action="FilterContacts" method="GET">
				<label for="filter">Search contacts: </label>
				<input type="text" name="filter" id="filter" value="${filter }">
				<input type="submit" name="submit" value="Search">
			</form>
		</div>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Occupation</th>
				</tr>
			</thead>
			<c:forEach var="contact" items="${contacts }">
			<tr>
				<td>${contact.id }</td>
				<td>${contact.firstName }</td>
				<td>${contact.name.toUpperCase() }</td>
				<td>${contact.occupation }</td>
				<td><form action="SelectContact" method="GET">			
						<input type="hidden" name="id_contact" value="${contact.id }">
						<input type="submit" name="submit" value="Select Contact">
					</form></td>
				<td><form action="DropContact" method="GET">
						<input type="hidden" name="contact_id" value="${contact.id}">
						<input type="submit" name="submit" value="Delete Contact">
					</form></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
    	<form action="AddContact" method="GET">
        	<input type="submit" name="add_contact" value="Add Contact">
    	</form>
    	<form action="Configuration" method="GET">
    		<input type="submit" name="submit" value="Configuration">
    	</form>
    </div>
</body>
</html>