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
                <div>
                    <label for="title">Title: </label>
                    <input type="text" name="title" id="title" value="${movie.title }" disabled>
                </div>
                <div>
                    <label for="release">Release year: </label>
                    <input type="text" name="release" id="release" value="${movie.releaseDate }" disabled>
                </div>
                <div>
                    <label for="category">Category: </label>
                    <input type="text" name="category" id="category" value="${movie.category.categoryName }" disabled>
                </div>
                <div>
                    <label for="director">Director: </label>
                    <input type="text" name="director_first_name" id="director" value="${movie.director.firstName }" disabled>
                    <input type="text" name="director_last_name" value="${movie.director.lastName }" disabled>
                </div>
                <div>
                    <label for="duration">Duration: </label>
                    <input type="text" name="duration" id="duration" value="${movie.duration }" disabled>
                </div>
                <div>
                    <label for="seen">Seen: </label>
                    <input type="text" name="seen" id="seen" value="${movie.seen? "Yes" : "No" }" disabled>
                </div>
                <c:forEach var="actor" items="${movie.actors }" varStatus="status">
					<div>
						<label for="actor${status.index }">Actor ${status.index + 1 }</label>
						<input type="text" id="actor${status.index }" value="${actor.firstName }" disabled>
						<input type="text" value="${actor.lastName }" disabled>
					</div>
				</c:forEach>
                <div>
                    <label for="synopsis">Synopsis: </label>
                    <textarea name="synopsis" id="synopsis" disabled>${movie.synopsis }</textarea>
                </div>
        </div>
    </main>

</body>
</html>