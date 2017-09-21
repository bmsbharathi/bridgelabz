package com.bridgeit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.DAO.UserMapperImpl;
import com.bridgeit.Model.Login;
import com.bridgeit.Model.Register;

@Service
public class UserService {

	@Autowired
	UserMapperImpl mapperimpl;

	public void insertuser(Register user) {
		mapperimpl.insertUser(user);
	}

	public Register getUser(Login user) {
		Register reg = mapperimpl.getUser(user);

		return reg;
	}

	public String checkUser(String uname) {
		String name = mapperimpl.checkUser(uname);
		System.out.println("Name: " + name);
		return name;
	}

	public String getEmail(String uname) {
		String email = mapperimpl.getEmail(uname);
		System.out.println("Email: " + email);
		return email;
	}

	public void updatePass(String email, String pass) {

		mapperimpl.updatePass(email, pass);
		System.out.println("ENTERED2");

	}
}
