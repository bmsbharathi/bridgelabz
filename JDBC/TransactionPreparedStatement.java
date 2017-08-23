import java.sql.*;
import java.util.Scanner;

public class TransactionPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String toAcc, fromAcc;
		int amt;
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
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/myDb?user=root&password=root");
			System.out.println("Connection Successfull");
			st = conection.createStatement();
			conection.setAutoCommit(false);
			
			//st.execute(createTableQuery);
			
			System.out.println("Enter the Account number, Account name");
			pst = conection.prepareStatement("INSERT INTO bank VALUES(?,?,?");
			pst.setInt(1, scan.nextInt());
			pst.setString(2, scan.next());
			pst.setInt(3, 10000);
			pst.addBatch();
			
			System.out.println("Enter the Account number, Account name");
			pst = conection.prepareStatement("INSERT INTO bank VALUES(?,?,?");
			pst.setInt(1, scan.nextInt());
			pst.setString(2, scan.next());
			pst.setInt(3, 10000);
			pst.addBatch();
			
			System.out.println("From accountname To accountname");	
			fromAcc = scan.next();
			toAcc = scan.next();
			
			pst = conection.prepareStatement("UPDATE bank SET balance = ? WHERE accname = ?");
			pst.setInt(1, 14000);
			pst.setString(2, toAcc);
			pst.addBatch();
			
					
			pst = conection.prepareStatement("UPDATE bank SET balance = ? WHERE accname = ?");
			pst.setInt(1, 6000);
			pst.setString(2, fromAcc);
			pst.addBatch();
			
			
			pst.executeBatch();
			conection.commit();
			System.out.println("Table created Successfully");
			System.out.println("\nAdding Rs2000 from bms to BHARATHI\n");
			System.out.println("\nTable Entries");
			
			
			rs = st.executeQuery("SELECT * FROM myDb.bank");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			System.out.println("Hell");
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
