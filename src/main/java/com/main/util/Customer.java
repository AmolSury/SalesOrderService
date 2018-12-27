package com.main.util;

public class Customer {
	
	private Long CustId;

	private String firstName;

	private String lastName;

	private String emailId;
	
	private String messageStatus;

	public Customer() {

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
		return "Customer [CustId=" + CustId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", messageStatus=" + messageStatus + "]";
	}
}
