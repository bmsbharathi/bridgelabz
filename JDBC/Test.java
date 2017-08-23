import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test{
	public static void main(String args[]) {
		Connection conection = null;
		Statement st = null;
		ResultSet rs = null;
		String createTableQuery = "CREATE TABLE FCB("+
				"JNO INTEGER(2),"+
				"name VARCHAR(20) primary key,"+
				"position VARCHAR(10)"+
				");";
		String query = "INSERT INTO FCB values(7,'BMS','DEF')";
		String query2 = "INSERT INTO FCB values(17,'PEDRO','FWD')";
		String query3 = "SELECT * FROM FCB WHERE position = 'DEF'";
		String query4 = "DELETE FROM FCB WHERE JNO = 17";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/myDb?user=root&password=root");
			System.out.println("Connection Successfull");
			st = conection.createStatement();
			
			DatabaseMetaData dmeta = conection.getMetaData();
			
			st.executeUpdate(createTableQuery);
			System.out.println("Table Created");
			
			System.out.println("INSERTING..");
			st.execute(query);
			st.execute(query2);
			
			rs = st.executeQuery("SELECT * FROM FCB");	
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			System.out.println("\nONLYDEFENDERS:");
			rs = st.executeQuery(query3);
			while(rs.next()) {
				System.out.println(rs.getInt("JNO")+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			System.out.println("\nAFTER DELETING JNO: 17..");
			st.execute(query4);
			rs = st.executeQuery("SELECT * FROM FCB");	
			while(rs.next()) {
				System.out.println(rs.getInt("JNO")+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			System.out.println("\n"+dmeta +"\n"+ dmeta.getDriverName()+"\n"+dmeta.getDriverVersion());
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("\n"+rsmd +"\n"+ rsmd.getColumnCount()+"\n");
		
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				if(rs != null) {
					
					rs.close();
				}
				if(st != null) {
					
					st.close();
				}
				if(conection != null) {
					
					conection.close();
				}
			}
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}



