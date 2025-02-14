package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bll.CategoryBLL;
import bo.Category;
import exceptions.CategoryException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoriesServlet
 */
@WebServlet("/Categories")
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryBLL catBLL = new CategoryBLL();
		List<Category> categories = catBLL.select();
		
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLServer");
		EntityManager em = emf.createEntityManager();
		
		CategoryBLL catBLL = new CategoryBLL();
		String categoryName = request.getParameter("category");
		
		try {
			catBLL.insert(new Category(categoryName));
		} catch (CategoryException e) {
			System.err.println("Error when creating category" + e.getMessage());
		}
		
		em.close();
		emf.close();
		response.sendRedirect("Categories");
	}

}
