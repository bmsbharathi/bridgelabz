package com.bridgeit.registration.Model;


/*POJO class to store all the details from registration page*/
public class User {
	
	/*Data members*/
	
	private String name;
	private String id;
	private String email;
	private String gender;
	private String password;
	private String mobileNo;

	/*Non parameterized Constructor*/
	public User() {
		super();
	
	}

	/*Setters and Getters*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/*Overridden toString method*/
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", email=" + email + ", gender=" + gender + ", password="
				+ password + ", mobileNo=" + mobileNo + "]";
	}

	
	
	
	
	
	
}
