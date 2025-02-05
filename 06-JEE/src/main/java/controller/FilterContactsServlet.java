package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.ContactBLL;
import bo.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FilterContacts")
public class FilterContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactBLL contactBLL = new ContactBLL();
		List<Contact> contacts = contactBLL.select();
		List<Contact> contactsToPrint = new ArrayList<>();
		
		String filter = request.getParameter("filter");
		for(Contact contact : contacts) {
			if(contact.getFirstName().toUpperCase().contains(filter.toUpperCase()) 
					|| contact.getName().toUpperCase().contains(filter.toUpperCase())
					|| contact.getOccupation().toUpperCase().contains(filter.toUpperCase())) {
				contactsToPrint.add(contact);
			}
		}
		
		request.setAttribute("filter", filter);
		request.setAttribute("contacts", contactsToPrint);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);		
	}

}
