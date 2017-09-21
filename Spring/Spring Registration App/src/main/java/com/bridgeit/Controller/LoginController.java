package com.bridgeit.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.Model.Login;
import com.bridgeit.Model.Register;
import com.bridgeit.Services.FormValidater;
import com.bridgeit.Services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;

	@Autowired
	FormValidater validator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView dologinbean() {

		ModelAndView mav = new ModelAndView("login");
		Login loginuser = new Login();
		mav.addObject("loginuser", loginuser);
		return mav;

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("login");

		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/";

	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView goToLogin() {

		ModelAndView mav = new ModelAndView("login");
		Login loginuser = new Login();
		mav.addObject("loginuser", loginuser);
		return mav;

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginuser(@Valid @ModelAttribute("loginuser") Login loginuser, BindingResult result,
			HttpServletRequest request, HttpSession session) {

		if (result.hasErrors()) {

			ModelAndView mav = new ModelAndView("login");

			return mav;
		} else {

			System.out.println(loginuser.getUsername());

			session = request.getSession(true);
			session.setAttribute("userObject", loginuser);

			Register reg = service.getUser(loginuser);
			ModelAndView mav = null;
			if (reg != null) {
				System.out.println(reg.getUsername() + " " + reg.getPassword());
				mav = new ModelAndView("welcomelogin", "Login", reg);
				mav.addObject("loginuser", loginuser);
			} else {
				mav = new ModelAndView("login", "message", "Invalid Login");
			}
			return mav;
		}
	}

}
