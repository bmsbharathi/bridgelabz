package com.bridgeit.registration.Controller;

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.registration.Model.User;
import com.bridgeit.registration.Service.FormValidator;

/*Controller to perform login operations*/
@Controller
public class LoginController {

	@Autowired
	FormValidator validator;
	static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("/")
	public ModelAndView getHomePage() {
		logger.warn("Inside / Controller");
		ModelAndView model = new ModelAndView("index");

		User loginuser = new User();
		model.addObject("loginuser", loginuser);

		return model;
	}

	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public ModelAndView getWelcomePage(@ModelAttribute("loginuser") User user, BindingResult result) {

		ModelAndView mav = null;
		logger.warn("Inside welcome page Controller");

		validator.validate1(user, result);

		if (result.hasErrors()) {

			mav = new ModelAndView("redirect:/");
			return mav;
		} else {

			mav = new ModelAndView("welcome");
			return mav;
		}

	}

}
