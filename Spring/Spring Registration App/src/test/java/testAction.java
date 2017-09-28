import javax.servlet.http.HttpServletRequest; 

import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testAction{

	@BeforeClass
	public void printTest() {
		System.out.println("Hellllllllllll!");
	}
	@Test
	public void test() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletRequest response = mock(HttpServletRequest.class);
		
		when(request.getParameter("name")).thenReturn("bmsbms");
		when(request.getParameter("password")).thenReturn("bharathi1");
		
		new 
		
		
	}
	
	
}
