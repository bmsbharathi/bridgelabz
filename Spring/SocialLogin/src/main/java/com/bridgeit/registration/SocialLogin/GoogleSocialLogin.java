
package com.bridgeit.registration.SocialLogin;

import javax.ws.rs.core.MediaType;  

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Service;

import com.bridgeit.registration.Model.GmailProfile;
import com.bridgeit.registration.Model.GmailToken;


@Service
public class GoogleSocialLogin {

	static final Logger logger = Logger.getLogger(GoogleSocialLogin.class);

	private static String sScope = "profile email";
	private static String sGmail_CLIENT_ID = "210547452486-1lin2i9diu2gjbtvp2vubq89042lie45.apps.googleusercontent.com";
	private static String sGmail_SECRET_KEY = "N8S_lhGpLflCSsmswarykaGs";
	private static String sGmail_REDIRECT_URI = "/callBack";

	private static String sGmail_URL = "https://accounts.google.com/o/oauth2/v2/auth?client_id=%s&redirect_uri=%s&state=%s&"
			+ "response_type=code&scope=%s&approval_prompt=force&access_type=offline";

	//Access with POST method
	private static String sGmail_ACCESS_TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token";
	
	// place access token in header
	private static String sGmail_GET_USER_URL = "https://www.googleapis.com/plus/v1/people/me";
	
	public String getGmailUrl(String apiUrl, String stateCode) {
		logger.warn("Forming the GmailURL");

		apiUrl = apiUrl + sGmail_REDIRECT_URI;

		return new String().format(sGmail_URL, new String[] { sGmail_CLIENT_ID, apiUrl, stateCode, sScope });
	}


	public GmailProfile authUser(String authCode, String apiUrl) {
		logger.warn("Authenticating using the authCode");
		
		String accessToken = getAccessToken(authCode, apiUrl);
		
		return getGmailProfile(accessToken);
	}


	private GmailProfile getGmailProfile(String accessToken) {
		logger.warn("Inside get Gmail Profile method");
		
		String accProfileUrl = sGmail_GET_USER_URL;
		logger.warn(""+accProfileUrl);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(accProfileUrl);
		
		String authHeader = "Bearer "+accessToken;
		Response response = target.request().header("Authorization", authHeader).accept(MediaType.APPLICATION_JSON).get();
		
		GmailProfile profile = response.readEntity(GmailProfile.class);
		
		logger.warn(""+profile);
		client.close();
		
		return profile;
	}


	private String getAccessToken(String authCode, String appUrl) {
	
		logger.warn("getting Access Token");
		
		appUrl = appUrl + sGmail_REDIRECT_URI;
		String accTokenUrl = sGmail_ACCESS_TOKEN_URL;
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(accTokenUrl);
		
		Form form = new Form();
		form.param("client_id", sGmail_CLIENT_ID);
		form.param("client_secret", sGmail_SECRET_KEY);
		form.param("redirect_uri", appUrl);
		form.param("code", authCode);
		form.param("grant_type", "authorization_code");
		
		Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.form(form));
		
		GmailToken token = response.readEntity(GmailToken.class);
		logger.warn("Token :"+token);
		client.close();
		
		return token.getAccess_token();
		
	}
}
