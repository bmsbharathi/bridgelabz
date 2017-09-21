package com.bridgeit.Model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Login implements Serializable {

	private static final long serialVersionUID = 9179015705859221931L;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	
	public Login() {
		super();

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

	
}
