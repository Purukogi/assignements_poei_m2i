package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bo.User;

public class UserDAO {

	public List<User> select(){

		
		List<User> users = new ArrayList<>();
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				 PreparedStatement ps = cnx.prepareStatement("SELECT * FROM users");
	                ResultSet rs = ps.executeQuery();

	                while(rs.next()){
	                    users.add(convertResultSetToUser(rs));
	                }
	                
                cnx.close();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return users;
		
	}
	
	public User selectByUsername(String username) {
		User result = null;
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("SELECT * FROM users WHERE username = ?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					result = convertResultSetToUser(rs);
				}
               cnx.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public User selectByToken(String token) {
		User result = null;
		
		try{
			
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("SELECT * FROM users WHERE token = ?");
				ps.setString(1, token);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					result = convertResultSetToUser(rs);
				}
               cnx.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void insert(User user) {
		try{
			
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("INSERT INTO users (username, password, salt) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUsername());
				ps.setBytes(2, user.getPassword());
				ps.setBytes(3, user.getSalt());
				
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
               cnx.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private User convertResultSetToUser(ResultSet rs) throws SQLException {
		User user = new User(
				rs.getInt("id"),
				rs.getString("username"),
				rs.getBytes("password"),
				rs.getBytes("salt"),
				rs.getString("token")
				);
		return user;
	}

	public void updateToken(User user) {
		try {
			
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/admin");
			Connection cnx = ds.getConnection();
			
			if(!cnx.isClosed()) {
				PreparedStatement ps = cnx.prepareStatement("UPDATE users SET token = ? WHERE id = ?");
				ps.setString(1, user.getToken());
				ps.setInt(2, user.getId());
				ps.executeUpdate();
                cnx.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
}
