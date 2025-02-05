package bo;

public class Address {
	
	private int id;
	private int number;
	private String street;
	private String zipCode;
	private String city;
	
	public Address(int id, int number, String street, String zipCode, String city) {
		this.id = id;
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	public Address(int number, String street, String zipCode, String city) {
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public Address() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
		
}
