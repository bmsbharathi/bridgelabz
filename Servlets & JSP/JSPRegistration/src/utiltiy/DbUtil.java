package utiltiy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbUtil {
	public static Connection createConnection(String dbName)
	{
		String conn= "JDBC:mysql://localhost:3306/"+dbName+"?user=root&password=root";
		Connection conection = null;
		System.out.println(conn);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection(conn);
			
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return conection;
		
	}
	public static void closeConection(Connection conn) {
		try {
			conn.close();
			System.out.println("Closed Successfully!");
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
}
