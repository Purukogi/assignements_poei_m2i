package controller;

import java.io.IOException;

import bll.UserBLL;
import bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		UserBLL bll = new UserBLL();
		User user = bll.selectByUsernameAndPassword(username, password);
		if (user == null) {
			request.setAttribute("loginError", "Incorrect login credentials");
			request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp").forward(request, response);
		} else {
			if (remember != null) {
				String token = bll.generateToken(user);
				Cookie cookie = new Cookie("token", token);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Index");
		}
	}

}
