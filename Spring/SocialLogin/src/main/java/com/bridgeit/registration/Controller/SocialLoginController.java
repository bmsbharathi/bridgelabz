package com.bridgeit.registration.Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.registration.Model.GmailProfile;
import com.bridgeit.registration.SocialLogin.GoogleSocialLogin;

@Controller
public class SocialLoginController {

	@Autowired
	GoogleSocialLogin gplusService;
	static final Logger logger = Logger.getLogger(SocialLoginController.class);

	@RequestMapping("googleLogin")
	public void getGoogleAPI(HttpServletRequest request, HttpServletResponse response) {

		logger.warn("Inside google login Controller");
		
		String url = request.getRequestURL().toString();
		String apiUrl = url.substring(0, url.lastIndexOf('/'));
		String stateCode = UUID.randomUUID().toString();
		logger.warn("API url: "+apiUrl);
		logger.warn("Full url: "+url);
		request.getSession().setAttribute("stateCode",stateCode);
		
		String gmailURL = gplusService.getGmailUrl(apiUrl,stateCode);
		
		
		logger.warn("GMAIL url: "+gmailURL);
		
		try {
			response.sendRedirect(gmailURL);
			logger.warn("Redirect Successfull");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	@RequestMapping("callBack")
	public ModelAndView getGoogleCallback(HttpServletRequest request,HttpServletResponse response) {

		logger.warn("Inside google callback Controller");
		ModelAndView mav = null;
		String stateFromSession = (String) request.getSession().getAttribute("stateCode");
		String stateFromGmail = (String) request.getParameter("state");		
		String authCode = request.getParameter("code");

		
		if(stateFromSession == null || !stateFromGmail.equals(stateFromSession)) {
			
			try {
				
				response.sendRedirect("redirect:googleLogin");
			} catch (IOException e) {
				
				/*e.printStackTrace();*/
				System.out.println(e);
			}
		}

		String error = request.getParameter("error");
		if (error != null && error.trim().isEmpty()) {
			
			logger.warn("errosr\n"+error);
			return mav = new ModelAndView("redirect:/");
		}
		
		String url = request.getRequestURL().toString();
		String apiUrl = url.substring(0, url.lastIndexOf('/'));
		
		GmailProfile profile = gplusService.authUser(authCode, apiUrl); 
		logger.warn(""+profile);
		
		System.out.println("GOOGLE POJO   :"+profile);
		mav = new ModelAndView("welcome");
		mav.addObject("pojo", profile);
		
		return mav;
	}

}
