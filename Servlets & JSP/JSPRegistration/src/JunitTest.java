import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.mockito.Mockito;


public class JunitTest extends Mockito{
	
	@Test	
	public void action() throws ServletException, IOException {

		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
	    when(req.getParameter("uname")).thenReturn("Bharathi");
	    when(req.getParameter("pass")).thenReturn("Bharathi");
	    when(req.getRequestDispatcher("/Login.jsp")).thenReturn(rd);
				
		new Login().doPost(req,res);

		//verify(rd).include(req, res);	
		
		verify(req).getParameter("pass");
		verify(res).setContentType("text/html");;
		
		
	
		
		}
	

	


}