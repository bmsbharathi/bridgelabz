

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpGetDemo extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		String name,college,department,rollno;
 
		name = request.getParameter("name");
		college = request.getParameter("college");
		department = request.getParameter("department");
		rollno = request.getParameter("rollno");
		
		
		
		writer.print("<html><body bgcolor=\"papayawhip\" style=\"color:orange;\"><h1>Hello &nbsp;"+name+" !</h1><br>");
		writer.print("<p align=\"right\"><a href=\"http://localhost:8080/HttpServ/index2.html\" style=\"font-size:30px;\">Back</a></p>");
		writer.print("<font size=5 face='arial'><center>College:  "+college+"<br><br>Department: "+department+"<br><br>Roll No: "+rollno);
		writer.print("<br><br><button onClick=\"alert('Thank You');\">Okay!</button></center></font> ");
	
		writer.print("</body></html>");
	}
	
	
}
