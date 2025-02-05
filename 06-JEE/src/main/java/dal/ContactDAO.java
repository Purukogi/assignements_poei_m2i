package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bll.AddressBLL;
import bo.Address;
import bo.Contact;
import exceptions.AddressException;

public class ContactDAO {
	
	public List<Contact> select(){
		List<Contact> contacts = new ArrayList<>();
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				 PreparedStatement ps = cnx.prepareStatement("SELECT contacts.id, last_name, first_name, birthday, phone, socials, occupation, specialty, addresses.id as id_address, number, street, zip_code, city  FROM contacts\r\n"
				 		+ "	INNER JOIN addresses ON contacts.id = addresses.id_contact");
	                ResultSet rs = ps.executeQuery();

	                while(rs.next()){
	                    contacts.add(convertResultSetToContact(rs));
	                }
	                
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		return contacts;
	}
	
	public Contact select(int id) {
		Contact contact = new Contact();
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				 PreparedStatement ps = cnx.prepareStatement("SELECT contacts.id, last_name, first_name, birthday, phone, socials, occupation, specialty, addresses.id as id_address, number, street, zip_code, city  FROM contacts\r\n"
				 		+ "	INNER JOIN addresses ON contacts.id = addresses.id_contact\r\n"
				 		+ "	WHERE contacts.id = ?");
				 	ps.setInt(1, id);
	                ResultSet rs = ps.executeQuery();

	                while(rs.next()){
	                    contact = convertResultSetToContact(rs);
	                }
	                
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return contact;
	}
	
	public void insert(Contact contact) {
		
		try {
			
			AddressBLL addressBLL = new AddressBLL();
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement(
                        "INSERT INTO contacts (last_name, first_name, birthday, phone, socials, occupation, specialty)" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, contact.getName());
                ps.setString(2, contact.getFirstName());
                ps.setDate(3, Date.valueOf(contact.getBirthday()));
                ps.setString(4, contact.getPhoneNumber());
                ps.setString(5, contact.getSocials());
                ps.setString(6, contact.getOccupation());
                ps.setString(7, contact.getSpecialty());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    contact.setId(rs.getInt(1));
                }
                
                addressBLL.insert(contact.getAddress(), contact.getId());
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (AddressException e) {
			System.out.println("Error during contact insertion in the DB: " + e.getMessage());
		}		
		
	}
	
	public void update(Contact contact) {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("UPDATE contacts SET last_name = ?,"
						+ "first_name = ?,"
						+ "birthday = ?,"
						+ "phone = ?,"
						+ "socials = ?,"
						+ "occupation = ?,"
						+ "specialty = ? WHERE id = ?;");
				ps.setString(1, contact.getName());
                ps.setString(2, contact.getFirstName());
                ps.setDate(3, Date.valueOf(contact.getBirthday()));
                ps.setString(4, contact.getPhoneNumber());
                ps.setString(5, contact.getSocials());
                ps.setString(6, contact.getOccupation());
                ps.setString(7, contact.getSpecialty());
                ps.setInt(8, contact.getId());
                ps.executeUpdate();
			}
			
			cnx.close();
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void drop(int id) {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("DELETE FROM contacts WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
			}
			
			cnx.close();
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Contact convertResultSetToContact(ResultSet rs) throws SQLException {		
		
		Contact contact = new Contact();
		Address address = new Address();
		
		address.setId(rs.getInt("id_address"));
		address.setNumber(rs.getInt("number"));
		address.setStreet(rs.getString("street"));
		address.setZipCode(rs.getString("zip_code"));
		address.setCity(rs.getString("city"));
		
		contact.setId(rs.getInt("id"));
		contact.setName(rs.getString("last_name"));
		contact.setFirstName(rs.getString("first_name"));
		if(rs.getDate("birthday") != null) {
			contact.setBirthday(rs.getDate("birthday").toLocalDate());
		}
		contact.setPhoneNumber(rs.getString("phone"));
		contact.setSocials(rs.getString("socials"));
		contact.setOccupation(rs.getString("occupation"));
		contact.setSpecialty(rs.getString("specialty"));
		contact.setAddress(address);

        return contact;
		
	}
		
}


