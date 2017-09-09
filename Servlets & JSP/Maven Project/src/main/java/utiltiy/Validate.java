package utiltiy;

import java.util.ArrayList;

public final class Validate {

	public static boolean validate(String uname,String pass,int age,String education,String gender,String confpass) {
		boolean flag=true;
		
		if(uname == null || uname =="") {
			System.out.println("Invalid Username! try again");
		
			flag = false;
		}
		else if(pass == null || pass =="") {
			System.out.println("Password cannot be null");
		
			flag = false;
		}
		
		else if(!pass.equals(confpass)) {
			System.out.println("Password and Confirm password do not match");
			flag = false;
		
		}
		else if(age == 0) {
			System.out.println("Age should not be null or have a character");
			flag = false;
		
			
		}else if(gender == null || gender=="") {
			System.out.println("Gender field should not be null");
			flag = false;
		
			
		}else if(education == null || education == "") {
			System.out.println("Education field should not be null or have a character");
			flag = false;
		
		}
		else {
			System.out.println("HURRAY!!");
			flag = true;
			
		}
		return flag;
	}
	public static ArrayList<String> validatee(String uname,String pass,int age,String education,String gender,String confpass) {

		ArrayList<String> errors = new ArrayList<String>();
		
		if(uname == null || uname =="") {
			System.out.println("Invalid Username! try again");
			errors.add("Invalid Username!");

		}
		else if(pass == null || pass =="") {
			System.out.println("Password cannot be null");
			errors.add("Password cannot be null");

		}
		
		else if(!pass.equals(confpass)) {
			System.out.println("Password and Confirm password do not match");
			errors.add("Password and Confirm password do not match");
		}
		else if(age == 0) {
			System.out.println("Age should not be null or have a character");
			errors.add("Age should not be null or have a character");
			
		}else if(gender == null || gender=="") {
			System.out.println("Gender field should not be null");
			errors.add("Gender field should not be null");
			
		}else if(education == null || education == "") {
			System.out.println("Education field should not be null or have a character");
			errors.add("Education field should not be null or have a character");
		}
		else {
			System.out.println("HURRAY!!");
			
		}
		return errors;
	}
}
