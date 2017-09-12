import java.util.List;
import org.apache.ibatis.session.SqlSession;


public class UserService
{


 public static List<User> getAllUsers() {
	 
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  
  try{
	  
  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
 
  	return userMapper.getAllUsers();
  }
  finally{
  
	  sqlSession.close();
  }
 }
 
 public static void updateEmail(String uname,String email){
	 
	 System.out.println(uname+"     "+email);
	 
	 SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	  
	  try{
		  
	  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	  userMapper.updateEmail(uname, email);
	  sqlSession.commit();
	  }
	  finally{
	  
		  sqlSession.close();
	  }	 
	 
 }
 
 public static void delete(String uname) {
	 
	 SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	 
	 try {
		 
		 System.out.println(""+uname);
		 UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 userMapper.deleteUser(uname);
		 sqlSession.commit();
	 }
	 finally {
		 
		 sqlSession.close();
	 }
 }
 public static void insertUser(User user) {
	 
	 SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	 
	 try {
		 
		 UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 userMapper.insertUser(user);
		 sqlSession.commit();
	 }
	 finally {
		 
		 sqlSession.close();
	}
	 
 }

}