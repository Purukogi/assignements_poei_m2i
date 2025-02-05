package bo;

import java.time.LocalDate;

public class Contact {
	
	private int id;
	private String name;
	private String firstName;
	private LocalDate birthday;
	private String phoneNumber;
	private String socials;
	private String occupation;
	private String specialty;
	private Address address;
	
	public Contact(int id, String name, String firstName, LocalDate birthday, String phoneNumber, String socials,
			String occupation, String specialty, Address address) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.socials = socials;
		this.occupation = occupation;
		this.specialty = specialty;
		this.address = address;
	}

	public Contact(String name, String firstName, LocalDate birthday, String phoneNumber, String socials,
			String occupation, String specialty, Address address) {
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.socials = socials;
		this.occupation = occupation;
		this.specialty = specialty;
		this.address = address;
	}	
	
	public Contact() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSocials() {
		return socials;
	}

	public void setSocials(String socials) {
		this.socials = socials;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
