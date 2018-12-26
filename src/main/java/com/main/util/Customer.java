package com.main.util;

public class Customer {

	private Long id;
	
	private Long CustId;

	private String firstName;

	private String lastName;

	private String emailId;
	
	private String messageStatus;

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return CustId;
	}

	public void setCustId(Long custId) {
		CustId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", CustId=" + CustId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", messageStatus=" + messageStatus + "]";
	}

}
