

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


@WebServlet("/viewbooks")
public class ViewBooks extends HttpServlet {
	

	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				super.init();
				ServletContext servCont = getServletContext();
				Connection conection = null;
				PreparedStatement pst = null;	
				ResultSet rs = null;
				String isbn,name,author,publication,driverName;
				driverName = (String)servCont.getInitParameter("drivername");
				String query = "SELECT * FROM bookdetails";
				PrintWriter writer = response.getWriter(); 
				int count =1;
				try{
					Class.forName(driverName);
					conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/librarymanagement?user=root&password=root");
					writer = response.getWriter();
					pst = conection.prepareStatement(query);
					rs = pst.executeQuery();
					
					writer.print("<!DOCTYPE html><html><head>" + 
							"<meta charset=\"UTF-8\">" + 
							"<title>Library Management System</title>" + 
							"<link rel=\"stylesheet\" type=\"text/css\" href=\"myStyle.css\"></head>" + 
							"<body>" + 
							"<p align=\"right\"> <font color=\"black\"><a href=\"http://localhost:8080/LibraryManagement/index.html\">Back</a></font></p>"+		 
							"	<div id =\"container\">" + 
							"		<center><h1>View Books</h1></center>" + 
							"		<div id =\"body\">" + 
							"");
					
					while(rs.next()) {
						
						writer.print("<fieldset><p align=\"right\"> <font color=\"black\">Entry: "+count+"</font></p>");
						count++;
						writer.print("<br>NAME:<font color=\"black\">"+rs.getString(2)+"</font><br><br>");
						writer.print("ISBN:<font color=\"black\">"+rs.getString(1)+"</font><br><br>");
						writer.print("AUTHOR:<font color=\"black\">"+rs.getString(3)+"</font><br><br>");
						writer.print("PUBLICATION:<font color=\"black\">"+rs.getString(4)+"</font><br><br>");
						writer.print("POSITION:<font color=\"black\">"+rs.getString(5)+"</font><br><br>");
					}
						writer.print("</div>" + 
								"	</div></body></html>");;
					
					
				}catch (ClassNotFoundException | SQLException e) {
					System.out.println(""+e);
				}
		
	}

}
