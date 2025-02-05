package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import bll.ContactBLL;
import bo.Address;
import bo.Contact;
import exceptions.ContactException;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/add_contact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address = new Address(
				Integer.valueOf(request.getParameter("number")),
				request.getParameter("street"),
				request.getParameter("zip_code"),
				request.getParameter("city")
				);
		
		Contact contact = new Contact(
				request.getParameter("name"),
				request.getParameter("first_name"),
				LocalDate.parse(request.getParameter("birthday")),
				request.getParameter("phone"),
				request.getParameter("socials"),
				request.getParameter("occupation"),
				request.getParameter("specialty"),
				address
				);		
		
		ContactBLL contactBLL = new ContactBLL();
		
		try {
			contactBLL.insert(contact);
		} catch (ContactException e) {
			System.out.println("Error during contact creation: " + e.getMessage());
		}
		
		response.sendRedirect("SelectContact?id_contact=" + contact.getId());
	}
	
	

}
