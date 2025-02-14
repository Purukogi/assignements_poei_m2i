<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>${movie.title }</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
    <main>
        <h2>Your Movie</h2>
        <div>
        	<form action="UpdateMovie" method="POST">
        		<input type="hidden" name="movie_id" value="${movie.id }">
                <div>
                    <label for="title">Title: </label>
                    <input type="text" name="title" id="title" value="${movie.title }">
                </div>
                <div>
                    <label for="release">Release year: </label>
                    <input type="text" name="release" id="release" value="${movie.releaseDate }">
                </div>
                <div>
                    <label for="category">Category: </label>
                    <input type="hidden" name="category_id" value="${movie.category.id }">
                    <input type="text" name="category" id="category" value="${movie.category.categoryName }">
                </div>
                <div>
                    <label for="director">Director: </label>
                    <input type="text" name="director_first_name" id="director" value="${movie.director.firstName }">
                    <input type="text" name="director_last_name" value="${movie.director.lastName }">
                </div>
                <div>
                    <label for="duration">Duration: </label>
                    <input type="text" name="duration" id="duration" value="${movie.duration }">
                </div>
                <div>
                    <label for="seen">Seen: </label>
                    <select name="seen" id="seen">
                        <option value="yes">Yes</option>
                        <c:if test="${!movie.seen }">
                        	<option value="no" selected>No</option>
                        </c:if>
                        <c:if test="${movie.seen }">
                        	<option value="no" >No</option>
                        </c:if>
                    </select>
                </div>
                <div>
                    <label for="actor1">Actor 1: </label>
                    <input type="text" name="actor1_first_name" id="actor1" placeholder="First Name" value="${movie.actors.get(0).firstName }">
                    <input type="text" name="actor1_last_name" placeholder="Last Name" value="${movie.actors.get(0).lastName }">
                </div>
                <div>
                    <label for="actor2">Actor 2: </label>
                    <input type="text" name="actor2_first_name" id="actor2" placeholder="First Name" value="${movie.actors.size() == 2 ? movie.actors.get(1).firstName : null }">
                    <input type="text" name="actor2_last_name" placeholder="Last Name" value="${movie.actors.size() == 2 ? movie.actors.get(1).lastName : null }">
                </div>
                <div>
                    <label for="actor3">Actor 3: </label>
                    <input type="text" name="actor3_first_name" id="actor3" placeholder="First Name" value="${movie.actors.size() == 3 ? movie.actors.get(2).firstName : null }">
                    <input type="text" name="actor3_last_name" placeholder="Last Name" value="${movie.actors.size() == 3 ? movie.actors.get(2).lastName : null }">
                </div>
                <div>
                    <label for="actor4">Actor 4: </label>
                    <input type="text" name="actor4_first_name" id="actor4" placeholder="First Name" value="${movie.actors.size() == 4 ? movie.actors.get(3).firstName : null }">
                    <input type="text" name="actor4_last_name" placeholder="Last Name" value="${movie.actors.size() == 4 ? movie.actors.get(3).lastName : null }">
                </div>
                <div>
                    <label for="actor5">Actor 5: </label>
                    <input type="text" name="actor5_first_name" id="actor5" placeholder="First Name" value="${movie.actors.size() == 5 ? movie.actors.get(4).firstName : null }">
                    <input type="text" name="actor5_last_name" placeholder="Last Name" value="${movie.actors.size() == 5 ? movie.actors.get(4).firstName : null }">
                </div>
                <div>
                    <label for="synopsis">Synopsis: </label>
                    <textarea name="synopsis" id="synopsis" >${movie.synopsis }</textarea>
                </div>
                <input type="submit" value="Update Movie">
             </form>
        </div>
    </main>

</body>
</html>