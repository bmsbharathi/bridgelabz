import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import org.junit.Test;

public class JunitTest2{
	


	@Test
	public void action2() throws ServletException, IOException {

		HttpServletRequest reqq = mock(HttpServletRequest.class);
		HttpServletResponse ress = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
	 

		    when(reqq.getParameter("uname")).thenReturn("");
		    when(reqq.getParameter("pass")).thenReturn("qwe");
		    when(reqq.getParameter("age")).thenReturn("24");
		    when(reqq.getParameter("confpass")).thenReturn("qwe");
		    when(reqq.getParameter("gender")).thenReturn("Male");
		    when(reqq.getParameter("education")).thenReturn("Diploma");
		    when(reqq.getRequestDispatcher("signup.jsp")).thenReturn(rd);
		    
		    
			new Signup().doPost(reqq, ress);
			
			
			verify(reqq).getParameter("pass");
			verify(ress).setContentType("text/html");
			
		
			
		
	} 
}