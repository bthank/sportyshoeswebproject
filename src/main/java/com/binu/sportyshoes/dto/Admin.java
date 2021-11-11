package com.binu.sportyshoes.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Admin {
	
	
	@Id
	private String adminUserName;
	
	private String adminPassword;
	
	private String firstName;
	private String lastName;

	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date creationDate;
	
	@LastModifiedDate
	@Column(name = "last_updated_at", updatable = true)
	private Date lastUpdateDate;

	public Admin() {
		
	}

	public Admin(String adminUserName, String adminPassword, String firstName, String lastName, Date creationDate,
			Date lastUpdateDate) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminUserName == null) ? 0 : adminUserName.hashCode());
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
		Admin other = (Admin) obj;
		if (adminUserName == null) {
			if (other.adminUserName != null)
				return false;
		} else if (!adminUserName.equals(other.adminUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate
				+ "]";
	}


	
	
}
