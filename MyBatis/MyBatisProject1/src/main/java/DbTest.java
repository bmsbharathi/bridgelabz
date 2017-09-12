import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {
	
	public static void main(String args[]) {
	
		try {
			
			Connection conection = null;
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/JSPreg?user=root&password=root");
			String query = "SELECT * FROM userdetails";
			Statement st = conection.createStatement();
			ResultSet rs = 	st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	}
}
