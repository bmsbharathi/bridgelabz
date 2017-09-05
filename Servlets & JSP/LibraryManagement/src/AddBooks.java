import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addbooks")
public class AddBooks extends HttpServlet {
  /*     
    public AddBooks() {
        super();
    }
    */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	ServletContext servCont = getServletContext();
	Connection conection = null;
	PreparedStatement pst = null;	
	String isbn,name,author,publication,driverName;
	driverName = (String)servCont.getInitParameter("drivername");
	String query = "INSERT INTO bookdetails VALUES(?,?,?,?,?)",rack;
	int shelfno;
	int rackno;
	isbn = request.getParameter("isbn");
	publication = request.getParameter("publication");
	author = request.getParameter("author");
	name = request.getParameter("name");
	Random r = new Random();
	rackno = r.nextInt(127);
	shelfno = r.nextInt(2000);
	rack = ""+rackno+"."+shelfno+"";
	PrintWriter writer = null;
	try {
		System.out.println(driverName);
		Class.forName(driverName);
		conection = DriverManager.getConnection("JDBC:mysql://localhost:3306/librarymanagement?user=root&password=root");
		writer = response.getWriter();
		pst = conection.prepareStatement(query);
		pst.setString(1, isbn);
		pst.setString(2, name);
		pst.setString(3, author);
		pst.setString(4, publication);
		pst.setString(5, rack);
		
		if(!pst.execute()) {
			response.setContentType("text/html");
			writer.print("<html><body bgcolor=\"papayawhip\"><script>alert('Inserted successfully');"+
			"window.location=\"http://localhost:8080/LibraryManagement/index.html\";</script>");
			writer.print("</body></html>");
				
		}
			
	}
	catch(ClassNotFoundException | SQLException e) {
		System.out.println(e);
	}
	
	}

}
