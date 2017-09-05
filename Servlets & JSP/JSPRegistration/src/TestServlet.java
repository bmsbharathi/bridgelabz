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


public class TestServlet extends Mockito{
	
	@Test	
	public void action() {

		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
				
	    when(req.getParameter("uname")).thenReturn("Bharathi");
	    when(req.getParameter("pass")).thenReturn("Bharathi");
	    PrintWriter writer;
		try {
			writer = new PrintWriter("bms.txt");
			when(res.getWriter()).thenReturn(writer);
		} catch (IOException e) {

			e.printStackTrace();
		} 
 
	    try {    
	  
			new Login().doPost(req,res);
			
			verify(req).getParameter("pass");
//			assertEquals("text/css", res.getContentType());
			
			verify(res).setContentType("textttt");;
			verify(req.getRequestDispatcher("/Login.sp"));
			
		} catch (ServletException | NullPointerException | IOException e) {

			System.out.println(e);
		}
	}

/*	 @Test
	
	public void action2() {

		HttpServletRequest reqq = mock(HttpServletRequest.class);
		HttpServletResponse ress = mock(HttpServletResponse.class);
		
	    try {    

		    when(reqq.getParameter("uname")).thenReturn("balaa");
		    when(reqq.getParameter("pass")).thenReturn("qwe");
		    when(reqq.getParameter("age")).thenReturn("24");
		    when(reqq.getParameter("confpass")).thenReturn("qwe");
		    when(reqq.getParameter("gender")).thenReturn("Male");
		    when(reqq.getParameter("education")).thenReturn("Diploma");
		    
		    
			new Signup().doPost(reqq,ress);
			
			verify(reqq).getParameter("pass"); 
			verify(reqq).getRequestDispatcher("login.jsp");
			//assertNotNull(reqq.getParameter("pass"));
			
		    
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	} 
*/

	}
