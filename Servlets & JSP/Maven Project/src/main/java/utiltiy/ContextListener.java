package utiltiy;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener{

	private ServletContext context;
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Application is Going to be destroyed");
		
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		this.context = arg0.getServletContext();
		System.out.println("Application Name: "+context.getInitParameter("appName"));
		System.out.println("Application is Starting up");
		//context.setAttribute("Test", "Test-value");
	}

}
