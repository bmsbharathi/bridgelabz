

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext servCont = getServletContext();
		Connection conection = null;
		PreparedStatement pst = null;	
		ResultSet rs = null;
		String uname,password,driverName;
		driverName = (String)servCont.getInitParameter("drivername");
		uname = request.getParameter("uname");
		password = request.getParameter("pass");
		
		String query = "SELECT * FROM logindetails WHERE uname = ? AND password = ?";
		PrintWriter writer = response.getWriter(); 
		String query2 = "SELECT * FROM userdetails WHERE uname = ?";
		try {
			Class.forName(driverName);
			conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/loginAPP?user=root&password=root");
			writer = response.getWriter();
			
			pst = conection.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			writer.print("<html><body><center><p align=\"right\"><a href=\"http://localhost:8080/LoginServlet/index.html\">Back</a></p><center><h1></h1></center>");
			if(rs.next()) {
				pst = conection.prepareStatement(query2);
				pst.setString(1, uname);
				rs = pst.executeQuery();
				if(rs.next()) {
					writer.print("<br>NAME:"+rs.getString(1)+"<br><br>");
					writer.print("Age:"+rs.getInt(2)+"<br><br>");
					writer.print("Mail ID:"+rs.getString(3)+"<br><br>");
					writer.print("City:"+rs.getString(4)+"<br><br>");	
				}								
				
			}
			else{
				writer.print("UserName or Password doesn't match<br>");
			}
			writer.print("</body></center></html>");
				
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}

}
