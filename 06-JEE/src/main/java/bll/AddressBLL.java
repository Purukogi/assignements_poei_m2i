package bll;

import bo.Address;
import dal.AddressDAO;
import exceptions.AddressException;

public class AddressBLL {
	
	private AddressDAO dao = new AddressDAO();
	
	public Address select(int id) {
		return dao.select(id);
	}
	
	public void insert(Address address) throws AddressException {
		
		checkAddress(address);
		
		dao.insert(address);
	}
	
	public void insert(Address address, int id_contact) throws AddressException {
		
		checkAddress(address);
		
		dao.insert(address, id_contact); 
	}
	
	public void update(Address address, int id_contact) throws AddressException {
		//checks
		checkAddress(address);
		
		dao.update(address, id_contact);
	}
	
	public void drop(int id) {
		dao.drop(id);
	}
	
	public void checkAddress(Address address) throws AddressException {
		
		if(address.getStreet() == null || address.getStreet().isBlank()) {
			throw new AddressException("The street name must be filled in!");
		}
		
		if(address.getCity() == null || address.getCity().isBlank()) {
			throw new AddressException("The city's name must be filled in!");
		}
		
		if(address.getStreet().length() > 255) {
			throw new AddressException("The street name can't be over 255 characters!");
		}
		
		if(address.getZipCode().length() > 8) {
			throw new AddressException("The zip code can't be over 8 characters!");
		}
		
		if(address.getCity().length() > 64) {
			throw new AddressException("The city's name can't be over 64 characters!");
		}
		
	}
	
}
