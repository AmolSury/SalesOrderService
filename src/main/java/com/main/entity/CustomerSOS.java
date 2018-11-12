package com.main.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Customer_SOS")
public class CustomerSOS implements Serializable{
	
	/**
	 * @author Amol Suryavanshi
	 */
	private static final long serialVersionUID = -1557860153208317229L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@Column(name="cust_id")
	private Long custId;

	@Column(name="cust_first_name")
	private String custFirstName;
	
	@Column(name="cust_last_name")
	private String custLastName;
	
	@NotBlank
	@Column(name="cust_email")
	private String custEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + ((custFirstName == null) ? 0 : custFirstName.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((custLastName == null) ? 0 : custLastName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerSOS other = (CustomerSOS) obj;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custFirstName == null) {
			if (other.custFirstName != null)
				return false;
		} else if (!custFirstName.equals(other.custFirstName))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (custLastName == null) {
			if (other.custLastName != null)
				return false;
		} else if (!custLastName.equals(other.custLastName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
