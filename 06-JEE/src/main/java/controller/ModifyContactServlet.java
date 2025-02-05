package controller;

import java.io.IOException;
import java.time.LocalDate;

import bll.AddressBLL;
import bll.ContactBLL;
import bo.Address;
import bo.Contact;
import exceptions.AddressException;
import exceptions.ContactException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyContactServlet
 */
@WebServlet("/ModifyContact")
public class ModifyContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactBLL contactBLL = new ContactBLL();		
		Contact contact = contactBLL.select(Integer.valueOf(request.getParameter("contact_id")));
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/WEB-INF/jsp/modify_contact.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Address address = new Address(
				Integer.valueOf(request.getParameter("number")),
				request.getParameter("street"),
				request.getParameter("zip_code"),
				request.getParameter("city")
				);
		
		Contact contact = new Contact(
				Integer.valueOf(request.getParameter("contact_id")),
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
		AddressBLL addressBLL = new AddressBLL();
		
		try {
			contactBLL.update(contact);
			addressBLL.update(address, contact.getId());
		} catch (ContactException e) {
			System.out.println("Error during contact modification: " + e.getMessage());
		} catch (AddressException e) {
			System.out.println("Error during contact modification: " + e.getMessage());
		}
		
		response.sendRedirect("SelectContact?id_contact=" + contact.getId());
	}	

}
