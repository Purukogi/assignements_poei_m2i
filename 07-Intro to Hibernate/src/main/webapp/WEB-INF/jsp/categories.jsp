<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Movie Library</title>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
    <main>
        <div>
            <h2>Managing categories</h2>
            <table>
                <thead>
				<tr>
					<th>Id</th>
					<th>Category Name</th>
				</tr>
				</thead>
				<c:forEach var="category" items="${categories }">
					<tr>
						<td>${category.id }</td>
						<td><!-- <a href="UpdateCategory?category_id=${category.id }"><img alt="edit button" src="img/edit.jpg" class="edit"></a> -->
						 
						<form action="UpdateCategory" method="GET">			
							<input type="hidden" name="category_id" value="${category.id }">
							<input type="text" name="category" value="${category.categoryName }">
							<button type="submit" value="Update Category" id="submit_category"><img alt="edit button" src="img/edit.jpg" class="edit_button"></button>
							</form> 
						</td>
						<td><a href="DropCategory?category_id=${category.id }"><img alt="delete button" src="img/delete.jpg" class="edit_delete"></a></td>
					</tr>
				</c:forEach>
            </table>
        </div>

        <div>
            <h2>New category</h2>
            <form action="Categories" method="POST">
                <input type="text" name="category" id="category" placeholder="Category name">
                <input type="submit" value="Send">
            </form>
        </div>
        
    </main>

</body>
</html>