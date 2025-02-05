package bll;

import java.time.LocalDate;
import java.util.List;

import bo.Contact;
import dal.ContactDAO;
import exceptions.ContactException;

public class ContactBLL {
	private final ContactDAO dao = new ContactDAO();
	
	public List<Contact> select() {
		return dao.select();
	}
	
	public Contact select(int id) {
		return dao.select(id);
	}
	
	public void insert(Contact contact) throws ContactException {
		
		checkContact(contact);
		
		dao.insert(contact);
		
	}
	
	public void update(Contact contact) throws ContactException {
		checkContact(contact);
		
		dao.update(contact);
	}
	
	public void drop(int id) {
		dao.drop(id);
	}
	
	public void checkContact(Contact contact) throws ContactException {
		if(contact.getFirstName() == null || contact.getFirstName().isBlank()) {
			throw new ContactException("The first name must be filled in!");
		}
		
		if(contact.getName() == null || contact.getName().isBlank()) {
			throw new ContactException("The last name must be filled in!");
		}
		
		if(contact.getBirthday() == null) {
			throw new ContactException("The date of birth must be filled in!");
		}
		
		if(contact.getFirstName().length() > 50) {
			throw new ContactException("The first name must be under 50 characters!");
		}
		
		if(contact.getName().length() > 50) {
			throw new ContactException("The last name must be under 50 characters!");
		}
		
		if(contact.getBirthday().isAfter(LocalDate.now())) {
			throw new ContactException("The date of birth can't be after today!");
		}
		
	}

}
