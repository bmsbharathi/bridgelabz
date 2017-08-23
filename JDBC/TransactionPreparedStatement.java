import java.sql.*;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int toAcc, fromAcc;
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
			pst = conection.prepareStatement("INSERT INTO bank VALUES(?,?,?)");
			pst.setInt(1, scan.nextInt());
			pst.setString(2, scan.next());
			pst.setInt(3, 10000);
			pst.addBatch();

			System.out.println("Enter the Account number, Account name");
			pst.setInt(1, scan.nextInt());
			pst.setString(2, scan.next());
			pst.setInt(3, 10000);
			pst.addBatch();

			System.out.println("From accountno To accountno");
			fromAcc = scan.nextInt();
			toAcc = scan.nextInt();

			pst = conection.prepareStatement("UPDATE bank SET balance = ? WHERE accountno = ?");
			pst.setInt(1, 14000);
			pst.setInt(2, toAcc);
			pst.addBatch();

			pst.setInt(1, 6000);
			pst.setInt(2, fromAcc);
			pst.addBatch();

			System.out.println("Table created Successfully");
			System.out.println("\nAdding Rs2000 from bms to BHARATHI\n");
			System.out.println("\nTable Entries");

			pst.executeBatch();
			conection.commit();
			rs = st.executeQuery("SELECT * FROM myDb.bank");

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
