package com.bridgeit.registration.Service;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgeit.registration.Model.User;

@Service
public class FormValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		
		return User.class.equals(arg0);
	}

	public void validate(Object result, Errors errors) {
	
	User u = (User)result;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.error", "Name should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.error", "Id should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.error", "Gender should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.error", "Email should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.error", "Password should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "mobileNo.error", "MobileNo should not be empty");
	
	Pattern patt = Pattern.compile(
			"^((([!#$%&'*+\\-/=?^_`{|}~\\w])|([!#$%&'*+\\-/=?^_`{|}~\\w][!#$%&'*+\\-/=?^_`{|}~\\.\\w]{0,}[!#$%&'*+\\-/=?^_`{|}~\\w]))[@]\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)$");
	Matcher matcher = patt.matcher(u.getEmail());

	if (!matcher.find()) {
		
		errors.rejectValue("email", "error.email", "Invalid emailId");
	}

	patt = Pattern.compile("^(([a-zA-Z]+\\d+)|(\\d+[a-zA-Z]+))[a-zA-Z0-9]*$");
	matcher = patt.matcher(u.getPassword());

	if (!matcher.find()) {
			
		errors.rejectValue("password", "error.password", "Password should contain atleast one alphabet and one number");
	}
	
	if(u.getMobileNo().length() != 10) {
		
		errors.rejectValue("mobileNo", "error.mobileNo", "Mobile Number should contain 10 numbers");
	}
}

	public void validate1(Object result, Errors errors) {

	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.error", "email should not be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.error", "password should not be empty");
		
	}


}
