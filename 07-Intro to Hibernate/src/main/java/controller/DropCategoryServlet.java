package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.CategoryBLL;
import bo.Category;


@WebServlet("/DropCategory")
public class DropCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryBLL catBLL = new CategoryBLL();
		int id = Integer.valueOf(request.getParameter("category_id"));
		Category toDelete = catBLL.selectById(id);
		catBLL.delete(toDelete);
		
		response.sendRedirect("Categories");
	}

}
