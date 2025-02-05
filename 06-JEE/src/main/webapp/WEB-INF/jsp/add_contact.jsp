<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Add a contact</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Add a contact</h2>
    <div>
        <form action="AddContact" method="POST">
        	<fieldset>
        		<legend>Contact info:</legend>
        		<div>
        			<label for="name">Name: </label>
            		<input type="text" name="name" id="name">
        		</div>
        		<div>
        			<label for="first_name">First Name: </label>
            		<input type="text" name="first_name" id="first_name">
        		</div>
        		<div>
        			<label for="birthday">Date of birth: </label>
            		<input type="date" name="birthday" id="birthday">
        		</div>
        		<div>
        			<label for="phone">Phone: </label>
            		<input type="tel" name="phone" id="phone">
        		</div>
        		<div>
        			<label for="socials">Socials: </label>
            		<input type="text" name="socials" id="socials">
        		</div>
        		<div>
        			<label for="occupation">Occupation: </label>
            		<input type="text" name="occupation" id="occupation" value="${cookie.default_occupation.value.replace('+', ' ') }">
        		</div>
        		<div>
        			<label for="specialty">Specialty: </label>
            		<input type="text" name="specialty" id="specialty">
        		</div>
        	</fieldset>
            <fieldset>
            	<legend>Address:</legend>
            	<div>
            		<label for="number">Address Number: </label>
            		<input type="number" name="number" id="number">
            	</div>
            	<div>
            		<label for="street">Street: </label>
            		<input type="text" name="street" id="street">
            	</div>
            	<div>
            		<label for="zip_code">Zip Code: </label>
            		<input type="text" name="zip_code" id="zip_code">
            	</div>
            	<div>
            		<label for="city">City: </label>
            		<input type="text" name="city" id="city">
            	</div>
            </fieldset>
            <input type="submit" name="validation" value="Create Contact">
        </form>
    </div>
</body>
</html>