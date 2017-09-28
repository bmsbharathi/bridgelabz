package com.bridgeit.SocialLogin;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.Model.Register;
import com.bridgeit.Services.UserService;
import com.google.gson.Gson;

@Service
public class CallBack {

	final Logger loger = Logger.getLogger(CallBack.class);

	@Autowired
	UserService service;

	public Register getGoogleCallBack(String code) {

		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		Register user = null;
		String email;

		try {

			loger.warn("googleCallBack()");

			String temp = "", accessToken, exchangeTokens = "", data = "", tempToken,
					urlParameters = "code=" + code
							+ "&client_id=210547452486-1lin2i9diu2gjbtvp2vubq89042lie45.apps.googleusercontent.com"
							+ "&client_secret=N8S_lhGpLflCSsmswarykaGs"
							+ "&redirect_uri=http://localhost:8080/MVC2/callBack" + "&grant_type=authorization_code";

			loger.warn("My URL parameters:" + urlParameters);

			URL url = new URL("https://accounts.google.com/o/oauth2/token");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((tempToken = reader.readLine()) != null) {

				exchangeTokens += tempToken;
			}

			loger.warn("My URL parameters:" + urlParameters);
			System.out.println("Access Token: "+ exchangeTokens);
			accessToken = GsonUtils.getJsonElementString("access_token", exchangeTokens);
			loger.info("My AccessToken:" + accessToken);
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken);
			conn = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			loger.warn("Reading parameters");
			while ((temp = reader.readLine()) != null) {

				data += temp;
			}

			System.out.println("User Data: " + data);
			user = (Register) new Gson().fromJson(data, Register.class);
			// System.out.println(user);
			loger.error("UserData printed..");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		//System.out.println("Email of Google user" + user.getEmail());
		email = service.checkEmail(user.getEmail());
		//System.out.println("Email from db: " + email);

		if (email == null) {
			user.setUsername("   ");
			service.insertuser(user);

			loger.info("DB insertion...");
			return user;
		} else {
			return user;
		}
	}
}
