import java.sql.*;
import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Connection conection = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String createTableQuery = "CREATE TABLE bank(" + 
				"accountno BIGINT(20) PRIMARY KEY," + 
				"accname VARCHAR(20)," + 
				"balance BIGINT(10)" + 
				");";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/myDB?user=bmsbharathi&password=bmsbharathi");
			System.out.println("Connection Successfull");
			st = conection.createStatement();
			conection.setAutoCommit(false);
			
			st.addBatch("CREATE TABLE bank(accountno BIGINT(20) PRIMARY KEY,accname VARCHAR(20),balance BIGINT(10))");
			st.addBatch("INSERT INTO bank VALUES(2015032407,'bms',20000)");
			st.addBatch("INSERT INTO bank VALUES(2015032406,'BHARATHI',20000)");
			
			st.addBatch("UPDATE bank SET balance = 18000 WHERE accountno = 2015032407");
			st.addBatch("UPDATE bank SET balance = 22000 WHERE accountno = 2015032406");		
			st.executeBatch();
			
			System.out.println("Table created Successfully");

			System.out.println("\nAdding Rs2000 from bms to BHARATHI\n");
			System.out.println("\nTable Entries");
			
			rs = st.executeQuery("SELECT * FROM bank");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			}
			
			
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
