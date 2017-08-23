import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestPreparedStatement{
	public static void main(String args[]) {
		Connection conection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String createTableQuery = "CREATE TABLE rankcard(\n" + 
				"name VARCHAR(20)," + 
				"rank INTEGER(2)," + 
				"percentage INTEGER(3)," + 
				"rollno	INTEGER(6) primary key" + 
				");";
		String query = "INSERT INTO rankcard values(?,?,?,?)";
		String query2 = "SELECT * FROM rankcard";
		String query3 = "DELETE FROM rankcard WHERE rollno = ?";
		String query4 = "update rankcard set rank = ? where rollno = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/myDB?user=root&password=root");
			System.out.println("Connection Successfull");
			
 			/*pst = conection.prepareStatement(createTableQuery);
			pst.execute();*/
			System.out.println("Table created!");
			
			/*System.out.println("\nEnter the input (NAME, RANK, PERCENTAGE AND ROLLNO)");
			pst = conection.prepareStatement(query);
			pst.setString(1, scan.next());
			pst.setInt(2, scan.nextInt());
			pst.setInt(3, scan.nextInt());
			pst.setInt(4, scan.nextInt());
			pst.executeUpdate();
			
			
			System.out.println("\nEntries in table");
			pst = conection.prepareStatement(query2);
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			
			System.out.println("\nEnter the Rollno to delete");
			PreparedStatement pst1 = conection.prepareStatement(query3);
			pst1.setInt(1, scan.nextInt());
			pst1.executeUpdate();
			*/
			System.out.println("\nEntries in table");
			pst = conection.prepareStatement(query2);
			rs = pst.executeQuery();	
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			
			System.out.println("\nEnter the new Rank and Rollno");
			pst = conection.prepareStatement(query4);
			pst.setInt(1, scan.nextInt());
			pst.setInt(2, scan.nextInt());
			pst.executeUpdate();
			
			System.out.println("Entries in table");
			pst = conection.prepareStatement(query2);
			rs = pst.executeQuery();	
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
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
				if(pst != null) {
					
					pst.close();
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



