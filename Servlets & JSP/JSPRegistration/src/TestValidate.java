import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import utiltiy.DbUtil;
import utiltiy.Validate;

public class TestValidate {
	
	@Test
	public void validateTest() {
		String uname,pass,confpass,education,gender;
		int age;
		
		age=30;
		uname="";
		pass="aaa";
		confpass="aaa";
		gender="Female";
		education="Diploma";
		
		assertFalse(Validate.validate(uname,pass,age,education,gender,confpass));
		
		uname="Bharathi";
		assertTrue(Validate.validate(uname,pass,age,education,gender,confpass));
		
		
		assertNotNull(Validate.validatee(uname,pass,age,education,gender,confpass));
		
		
		assertNotNull(DbUtil.createConnection("myDb"));
		
		/*
		"httpget?name="+name+"&college="+colg+"&rollno="+rollno+"&department="+dept+"
		
		httpget?name=qq&college=qq&rollno=qq&department=qq*/
	}
	
}
