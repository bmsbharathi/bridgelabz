package utiltiy;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
	
	static int noOfSessions=1; 
		
	public void sessionCreated(HttpSessionEvent arg0) {
	

		System.out.println("Session Created!\tSession no:"+ noOfSessions);
		noOfSessions++;
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

		
		System.out.println("Session Destroyed ");
		
		
	}

}
