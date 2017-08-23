import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp{
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Connection conection = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String createTableQuery = "CREATE TABLE userdetails(\n" + 
				"uname VARCHAR(20) PRIMARY KEY,\n" + 
				"pass VARCHAR(20),\n" + 
				"email VARCHAR(50),\n" + 
				"age	INTEGER(3)\n" + 
				");",uname,pass,selectQuery = "SELECT email,age FROM userdetails WHERE uname = ? AND pass = ?;";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/myDB?user=bmsbharathi&password=bmsbharathi");
			System.out.println("Connection Successfull");
			st = conection.createStatement();
			
			//st.execute(createTableQuery);
			System.out.println("Table Created Successfully");
			
			System.out.println("\nEnter the Username");
			uname = scan.next();
			System.out.println("Enter the password");
			pass = scan.next();

			pst = conection.prepareStatement(selectQuery);
			pst.setString(1, uname);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();


			if(!rs.next()) {
				System.out.println("Invalid Credentials!");
			}
			rs = pst.executeQuery();
			if(rs.next()) {
				System.out.println("Logged In Successfully\n\nUserDetails:\nAge:"+rs.getString("age")+"\nEmail:"+rs.getString("email"));
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



