package com.bridgeit.registration.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bridgeit.registration.Model.User;
import com.bridgeit.registration.Service.FormValidator;

/*Controller to perform Registration operations*/
@Controller
public class RegistrationController {

	static final Logger logger = Logger.getLogger(RegistrationController.class);
	@Autowired
	FormValidator validator;
	
	@RequestMapping("register")
	public ModelAndView getRegistrationPage() {
		
	
		logger.info("Inside Registration Controller");
		
		ModelAndView model = new ModelAndView("Register");
		model.addObject("User", new User());
		
		return model;
	}
	
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("User") User user, BindingResult result, RedirectAttributes redirattr){
		
		validator.validate(user, result);
		
		if(!result.hasErrors()) {
			
			logger.info("Form validation: No Errors");
			
			return "redirect:/";
		}
		else {
			
			logger.info("Form validation: Found Errors");
			
			return "Register"; 
		}
	}
}
