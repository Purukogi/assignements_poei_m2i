package bo;

public class User {
	
	private int id;
	private String username;
	private byte[] password;
	private byte[] salt;
	private String token;
	
	public User(int id, String username, byte[] password, byte[] salt, String token) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.token = token;
	}

	public User(String username, byte[] password, byte[] salt, String token) {
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.token = token;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
