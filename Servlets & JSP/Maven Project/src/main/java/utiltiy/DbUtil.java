package utiltiy;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class DbUtil {
	
	static ComboPooledDataSource cpds = null;
	
	public static Connection createConnection(String dbName) throws SQLException 
	{
		if(cpds == null) {
		
		cpds = new ComboPooledDataSource();
		
		String url = "JDBC:mysql://localhost:3306/"+dbName; 
		System.out.println(url);
		try {
		
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl(url);
		cpds.setUser("root");                                  
		cpds.setPassword("root");                                  
		cpds.setMinPoolSize(1);                                     
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);			
		
		}
		catch(PropertyVetoException e) {
			
			System.out.println(e);
		}
		
	}
		return  cpds.getConnection();
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



/*String conn= "JDBC:mysql://localhost:3306/"+dbName+"?user=root&password=root";
Connection conection = null;
System.out.println(conn);


try {
	Class.forName("com.mysql.jdbc.Driver");
	conection = DriverManager.getConnection(conn);
	
}
catch(ClassNotFoundException | SQLException e) {
	System.out.println(e);
}*/