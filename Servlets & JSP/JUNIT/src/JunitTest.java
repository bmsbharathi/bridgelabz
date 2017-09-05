import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {  
	  
	 @BeforeClass
	  public static void printClass() {
		  System.out.println("BEFORECLASS EXECUTION---");
	  }
	
	
	@Before
	  public void print() {
		  System.out.println("BEFORE EXECUTION---");
	  }
	  
	  int arr[]={5,6,7,8,9};
    
	  @Test  
    public void testFind(){  
        assertEquals(4,TestMethods.findMax(new int[]{1,3,4,2}));
        assertEquals(9,TestMethods.findMax(arr));
        assertEquals(-1,TestMethods.findMax(new int[]{-12,-1,-3,-4,-2}));
        assertEquals(4,TestMethods.Findlength("HELL"));
        assertEquals(5,TestMethods.Findlength("HELL0"));
    } 
	  @Test
	  public void test(){  
	        assertEquals(4,TestMethods.findMax(new int[]{1,3,4,2}));
	        assertEquals(9,TestMethods.findMax(arr));
	        assertEquals(-1,TestMethods.findMax(new int[]{-12,-1,-3,-4,-2}));
	        assertEquals(4,TestMethods.Findlength("HELL"));
	        assertEquals(5,TestMethods.Findlength("HELL0"));
	        assertTrue(TestMethods.hasSomething("bms"));
	    }   
	  @After
	  public void printAfter() {
		  System.out.println("AFTER EXECUTION---");
		  
	  }
	  @AfterClass
	  public static void printAfterClass() {
		  System.out.println("AFTERCLASS EXECUTION---");
	  }
}  