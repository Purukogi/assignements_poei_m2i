package controller;

import java.io.IOException;

import bll.ContactBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DropContactServlet
 */
@WebServlet("/DropContact")
public class DropContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactBLL contactBLL = new ContactBLL();
		contactBLL.drop(Integer.valueOf(request.getParameter("contact_id")));
		response.sendRedirect("Index");
	}

}
