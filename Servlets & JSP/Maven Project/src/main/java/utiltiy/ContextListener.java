package utiltiy;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{

	private ServletContext context;
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Application is Going to be destroyed");
		
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		this.context = arg0.getServletContext();
		System.out.println(context.getInitParameter("appName"));
		System.out.println("Application is Starting up");
	}

}
