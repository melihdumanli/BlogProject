package com.bilgeadam.dto;

public class AdminDto extends CommonProperties {
	private static final long serialVersionUID = -6214174547778684454L;
	
	private int registerNumberOfRecords;
	
	// Constructor without parameters
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}
	
	// constructor with parameters
	public AdminDto(String name, String surname, String telNumber, String emailAddress, String password,
			int registerNumberOfRecords) {
		super(name, surname, telNumber, emailAddress, password);
		this.registerNumberOfRecords = registerNumberOfRecords;
	}
	
	// toString
	@Override
	public String toString() {
		return "AdminDto [registerNumberOfRecords=" + registerNumberOfRecords + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSurname()=" + getSurname() + ", getTelNumber()=" + getTelNumber()
				+ ", getEmailAddress()=" + getEmailAddress() + ", getPassword()=" + getPassword() + ", getCreateDate()="
				+ getCreateDate() + "]";
	}
	
	// getters and setters
	public int getRegisterNumberOfRecords() {
		return registerNumberOfRecords;
	}
	
	public void setRegisterNumberOfRecords(int registerNumberOfRecords) {
		this.registerNumberOfRecords = registerNumberOfRecords;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
