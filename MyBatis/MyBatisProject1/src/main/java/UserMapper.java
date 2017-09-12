import java.util.List;

	public interface UserMapper 
	{

		public void insertUser(User user);	
		public List<User> getAllUsers();
		public void deleteUser(String uname);
		public void updateEmail(String uname,String email);
	}
	 
