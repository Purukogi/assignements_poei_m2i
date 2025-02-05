package controller;

import java.io.IOException;

import bll.ContactBLL;
import bo.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectContact")
public class SelectContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactBLL contactBLL = new ContactBLL();
		Contact contact = new Contact();
		
		contact = contactBLL.select(Integer.valueOf(request.getParameter("id_contact")));
		request.setAttribute("contact", contact);		
		request.getRequestDispatcher("/WEB-INF/jsp/contact_info.jsp").forward(request, response);
	}

}
