package com.binu.sportyshoes.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class User {
	
	@Id
	private String userName;
	
	private String password;
	
	private String email;
	
	private String gender;
	private int age;
	
	private String firstName;
	private String lastName;
	
	@OneToOne
	private Address homeAddress;	
	private String homePhoneNo;
	
	private String cellPhoneNo;
	
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date creationDate;
	
	@LastModifiedDate
	@Column(name = "last_updated_at")
	private Date lastUpdateDate;

	public User() {
	}

	public User(String userName, String password, String email, String gender, int age, String firstName,
			String lastName, Address homeAddress, String homePhoneNo, String cellPhoneNo, Date creationDate,
			Date lastUpdateDate) {
		 
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
		this.homePhoneNo = homePhoneNo;
		this.cellPhoneNo = cellPhoneNo;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public User(String password, String email, String gender, int age, String firstName, String lastName,
			Address homeAddress, String homePhoneNo, String cellPhoneNo, Date creationDate, Date lastUpdateDate) {
		 
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
		this.homePhoneNo = homePhoneNo;
		this.cellPhoneNo = cellPhoneNo;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomePhoneNo() {
		return homePhoneNo;
	}

	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}

	public String getCellPhoneNo() {
		return cellPhoneNo;
	}

	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
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
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + ", homeAddress="
				+ homeAddress + ", homePhoneNo=" + homePhoneNo + ", cellPhoneNo=" + cellPhoneNo + ", creationDate="
				+ creationDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}



}
