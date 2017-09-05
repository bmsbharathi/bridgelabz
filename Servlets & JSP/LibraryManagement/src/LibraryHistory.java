

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryHistory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("Hell");
		ServletConfig config = getServletConfig();
		PrintWriter writer = response.getWriter();
		
		writer.print("<html><head><link rel = \"stylesheet\" type=\"text/css\" href=\"myStyle.css\"></head><p align=\"right\">"+
		
					"<font color=\"black\"><a href=\"http://localhost:8080/LibraryManagement/index.html\">Back</a></font></p><h1>"+				
					"History of the library</h1><center>This library was started in <b>"+		
					config.getInitParameter("startDate")+"</b> By the Brits. It was digitised on<b>"+config.getInitParameter("digitisedDate")+				
					"</b> by the MHRD.</center></html>");
		
	}


}
