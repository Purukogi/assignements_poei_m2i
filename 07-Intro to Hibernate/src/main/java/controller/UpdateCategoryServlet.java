package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.CategoryBLL;
import bo.Category;
import exceptions.CategoryException;


@WebServlet("/UpdateCategory")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryBLL catBLL = new CategoryBLL();
		
		int id = Integer.valueOf(request.getParameter("category_id"));
		String categoryName = request.getParameter("category");
		Category toUpdate = new Category(id, categoryName);
		
		try {
			catBLL.update(toUpdate);
		} catch (CategoryException e) {
			System.err.println("Error when creating category" + e.getMessage());
		}
		
		response.sendRedirect("Categories");
	}

}
