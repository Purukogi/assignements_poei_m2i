<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Modify a contact</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Modify a contact</h2>
	<p>Change the informations you want, then click the Modify Contact button.</p>
	<div>
        <form action="ModifyContact" method="POST">
        	<fieldset>
        		<legend>Contact info:</legend>
        		<input type="hidden" name="contact_id" value="${contact.id}">
        		<div>
        			<label for="name">Name: </label>
            		<input type="text" name="name" value="${contact.name}" id="name">
        		</div>
        		<div>
        			<label for="first_name">First Name: </label>
            		<input type="text" name="first_name" value="${contact.firstName}" id="first_name">
        		</div>
        		<div>
        			<label for="birthday">Date of birth: </label>
            		<input type="date" name="birthday" value="${contact.birthday}" id="birthday">
        		</div>
        		<div>
        			<label for="phone">Phone</label>
            		<input type="tel" name="phone" value="${contact.phoneNumber}" id="phone">
        		</div>
        		<div>
        			<label for="socials">Socials: </label>
            		<input type="text" name="socials" value="${contact.socials}" id="socials">
        		</div>
        		<div>
        			<label for="occupation">Occupation: </label>
            		<input type="text" name="occupation" value="${contact.occupation}" id="occupation">
        		</div>
        		<div>
        			<label for="specialty">Specialty</label>
            		<input type="text" name="specialty" value="${contact.specialty}" id="specialty">
        		</div>
        	</fieldset>
            <fieldset>
            	<legend>Address:</legend>
            	<div>
            		<label for="number">Address Number: </label>
            		<input type="number" name="number" value="${contact.address.number}" id="number">
            	</div>
            	<div>
            		<label for="street">Street: </label>
            		<input type="text" name="street" value="${contact.address.street}" id="street">
            	</div>
            	<div>
            		<label for="zip_code">Zip Code: </label>
            		<input type="text" name="zip_code" value="${contact.address.zipCode}" id="zip_code">
            	</div>
            	<div>
            		<label for="city">City: </label>
            		<input type="text" name="city" value="${contact.address.city}" id="city">
            	</div>
            </fieldset>           
            <input type="submit" name="validation" value="Modify Contact">
        </form>
    </div>
</body>
</html>