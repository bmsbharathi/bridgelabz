package com.bridgeit.DAO;

import com.bridgeit.Model.Login;
import com.bridgeit.Model.Register;

public interface UserMapper {

	public void insertUser(Register user);

	public Register getUser(Login user);
	
	public String checkUser(String uname);
	
	public String getEmail(String uname);
	
	public void updatePass(String email,String pass);
}
