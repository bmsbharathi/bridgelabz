package utiltiy;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
	
	static int noOfSessions=0; 
	
	public void sessionCreated(HttpSessionEvent arg0) {
	
		noOfSessions++;
		System.out.println("Session Created\nSession no:"+noOfSessions);
		
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

		System.out.println("Session Destroyed");
		
	}

}
