<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Add a movie</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
    <main>
        <h2>Add a movie</h2>
        <div>
            <form action="AddMovie" method="POST" >
            	<div class="movie_form">
            		<div>
                    	<label for="title">Title: </label> 
                    </div>
                    <div>
                    	<input type="text" name="title" id="title" placeholder="Movie title">
                	</div>
                	
                	<div>
                    	<label for="release">Release Year: </label>
                    </div>
                    <div>
                    	<input type="text" name="release" id="release" placeholder="Release year">
                    </div>
                                    
                	<div>
                    	<label for="category">Category: </label> 
                    </div>
                    <div>
                    	<select name="category" id="category">
                        	<c:forEach var="category" items="${categories }">
								<option value="${category.id }">${category.categoryName }</option>
							</c:forEach>
                    	</select>
                	</div>
                	
                	<div>
                    	<label for="director">Director: </label>
                    </div>
                    <div>
                    	<input type="text" name="director_first_name" id="director" placeholder="First Name">
                    	<input type="text" name="director_last_name" placeholder="Last Name">
                    </div>
                	
                	<div>
                    	<label for="duration">Duration: </label>
                    </div>
                    <div>
                    	<input type="text" name="duration" id="duration" placeholder="Duration (h:mm)">
                    </div>
                	
                	<div>
                    	<label for="seen">Seen: </label>
                    </div>
                    <div>
                    	<select name="seen" id="seen">
                        	<option value="yes">Yes</option>
                        	<option value="no">No</option>
                    	</select>
                	</div>
                	
                	<div>
                    	<label for="actor1">Actor 1: </label>
                    </div>
                    <div>
                    	<input type="text" name="actor1_first_name" id="actor1" placeholder="First Name">
                    	<input type="text" name="actor1_last_name" placeholder="Last Name">
                    </div>
                
                	<div>
                    	<label for="actor2">Actor 2: </label>
                    </div>
                    <div>
                    	<input type="text" name="actor2_first_name" id="actor2" placeholder="First Name">
                    	<input type="text" name="actor2_last_name" placeholder="Last Name">
                    </div>
                
                	<div>
                    	<label for="actor3">Actor 3: </label>
                    </div>
                    <div>
                    	<input type="text" name="actor3_first_name" id="actor3" placeholder="First Name">
                    	<input type="text" name="actor3_last_name" placeholder="Last Name">
                    </div>
                
                	<div>
                    	<label for="actor4">Actor 4: </label>
                    </div>
                    <div>
                    	<input type="text" name="actor4_first_name" id="actor4" placeholder="First Name">
                    	<input type="text" name="actor4_last_name" placeholder="Last Name">
                    </div>
                
                	<div>
                    	<label for="actor5">Actor 5: </label>
                    </div>
                    <div>
                    	<input type="text" name="actor5_first_name" id="actor5" placeholder="First Name">
                    	<input type="text" name="actor5_last_name" placeholder="Last Name">
                    </div>
                	
                	<div>
                    	<label for="synopsis">Synopsis: </label>
                    </div>
                    <div>
                    	<textarea name="synopsis" id="synopsis"></textarea>
                    </div>
                </div>
                <input type="submit" value="Send">
            </form>
        </div>
    </main>

</body>
</html>