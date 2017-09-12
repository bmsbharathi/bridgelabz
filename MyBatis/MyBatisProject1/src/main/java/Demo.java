import java.util.List;
public class Demo {

	public static void main(String args[]) {
		  
	  User u = new User();
	  
	 
	  u.setGender("Male");
	  u.setEducation("Graduate");
	  u.setAge(32);		
	  u.setUname("asdasde");
	  u.setEmail("asdyne@gmail.com");
	 
	  //UserService.insertUser(u);
	  //UserService.updateEmail("Bruce Wayne", "threalbrucewayne@gmail.com");
	  //UserService.delete("Bruce Wayne");
	
	  List<User> users = UserService.getAllUsers(); 
	  
	  for (User user : users) {
		  
	   System.out.println(user);
	  }
  
		  
	  
		
	}

}
