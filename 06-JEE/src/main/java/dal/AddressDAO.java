package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bo.Address;

public class AddressDAO {
	
	public Address select(int id) {
		
		Address address = new Address();
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				 PreparedStatement ps = cnx.prepareStatement("SELECT * FROM addresses WHERE id=?");
				 	ps.setInt(1, id);
	                ResultSet rs = ps.executeQuery(); //pour executer un select

	                while(rs.next()){
	                    address = convertResultSetToAddress(rs);
	                }
	                
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return address;
	}
	
	
	public void insert(Address address) {
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement(
                        "INSERT INTO addresses (number, street, zip_code, city)" +
                                "VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, address.getNumber());
                ps.setString(2, address.getStreet());
                ps.setString(3, address.getZipCode());
                ps.setString(4, address.getCity());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    address.setId(rs.getInt(1));
                }
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void insert(Address address, int id_contact) {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement(
                        "INSERT INTO addresses (number, street, zip_code, city, id_contact)" +
                                "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, address.getNumber());
                ps.setString(2, address.getStreet());
                ps.setString(3, address.getZipCode());
                ps.setString(4, address.getCity());
                ps.setInt(5, id_contact);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    address.setId(rs.getInt(1));
                }
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void update(Address address, int id_contact) {
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("UPDATE addresses SET number = ?,"
						+ "street = ?,"
						+ "zip_code = ?,"
						+ "city = ? WHERE id = ?;");
				ps.setInt(1, address.getNumber());
                ps.setString(2, address.getStreet());
                ps.setString(3, address.getZipCode());
                ps.setString(4, address.getCity());
                ps.setInt(5, id_contact);
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
				PreparedStatement ps = cnx.prepareStatement("DELETE FROM addresses WHERE id=?");
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
	
	
	public Address convertResultSetToAddress(ResultSet rs) throws SQLException {
		
		Address address = new Address();
		
		address.setId(rs.getInt("id"));
		address.setStreet(rs.getString("street"));
		address.setZipCode(rs.getString("zip_code"));
		address.setCity(rs.getString("city"));

        return address;
	}

}
