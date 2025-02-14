<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Movie List</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h2>Movie List</h2>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Release Year</th>
				<th>Category</th>
				<th>Director</th>
				<th>Duration</th>
				<th>Seen</th>
			</tr>
		</thead>
		<c:forEach var="movie" items="${movies }">
			<tr>
				<td>${movie.id }</td>
				<td><a href="MoviePage?movie_id=${movie.id }">${movie.title }</a></td>
				<td>${movie.releaseDate }</td>
				<td>${movie.director.firstName } ${movie.director.lastName }</td>
				<td>${movie.duration }</td>
				<td>${movie.seen? "Yes" : "No" }</td>
				<td><a href="UpdateMovie?movie_id=${movie.id }"><img alt="edit button" src="img/edit.jpg" class="edit_delete"></a></td>
				<td><a href="DropMovie?movie_id=${movie.id }"><img alt="delete button" src="img/delete.jpg" class="edit_delete"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>