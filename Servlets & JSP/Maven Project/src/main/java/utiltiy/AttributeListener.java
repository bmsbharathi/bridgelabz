package utiltiy;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println(arg0.getName()+"attribute is added");
		
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		
		System.out.println(arg0.getName()+"attribute is Removed");
		
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
