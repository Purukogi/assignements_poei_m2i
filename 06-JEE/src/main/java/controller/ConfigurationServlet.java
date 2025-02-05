package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Configuration")
public class ConfigurationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("configuration_number") == null) {
			request.getSession().setAttribute("configuration_number", 1);
		}else {
			int configuration_number = (int) request.getSession().getAttribute("configuration_number") + 1;
			request.getSession().setAttribute("configuration_number", configuration_number);
		}		
		request.getRequestDispatcher("/WEB-INF/jsp/configuration.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("default").replace(' ', '+');
		Cookie defaultCookie = new Cookie("default_occupation", value);
		defaultCookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(defaultCookie);
		response.sendRedirect("Index");
	}

}
