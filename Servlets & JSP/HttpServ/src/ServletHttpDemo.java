

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHttpDemo extends HttpServlet {
       
	
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		String uname,password,number,mail;
		uname = request.getParameter("name");
		number = request.getParameter("number");
		mail = request.getParameter("mail");
		password = request.getParameter("password");
		
		writer.print("<html><body bgcolor=\"yellow\" style=\"color:blue;\"><h1>Hello &nbsp;"+uname+" !</h1><br>");
		writer.print("<p align=\"right\"><a href=\"http://localhost:8080/HttpServ/index.html\" style=\"font-size:30px;\">Back</a></p>");
		writer.print("<font size=5 face='arial'><center>MailID:  "+mail+"<br><br>Phone Number: "+number);
		writer.print("<br><br><button onClick=\"alert('Thank You');\">Okay!</button></center></font> ");	
		writer.print("</body></html>");
	}
	
	
}
