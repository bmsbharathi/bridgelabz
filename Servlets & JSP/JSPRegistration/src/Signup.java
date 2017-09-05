

import java.io.IOException;
import utiltiy.DbUtil;
import utiltiy.Validate;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conection = null;
		ArrayList<String> errors = new ArrayList<String>();
		String uname="",confpass="",pass="",gender="",education="",query1="INSERT INTO userdetails VALUES(?,?,?,?,?)",query2="INSERT INTO logindetails VALUES(?,?)";
		int age=0,flag=0;
		PrintWriter writer = response.getWriter();
		PreparedStatement pst = null;
		response.setContentType("text/html");
		
		
		try {
		
		age = Integer.parseInt(request.getParameter("age"));
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		confpass = request.getParameter("confpass");
		education = request.getParameter("education");
		gender = request.getParameter("gender");
		
		System.out.println(uname+" "+pass+" "+age+" "+education+" "+gender);
		
		errors = Validate.validatee(uname, pass, age, education, gender, confpass);
		Iterator iter = errors.iterator();
		
		int size = errors.size();
		
		if(size>0) {
			while(iter.hasNext()) {
				writer.print(iter.next());
			}
		}
		else {
			conection = DbUtil.createConnection("JSPreg");
			pst = conection.prepareStatement(query1);
			pst.setString(1, uname);
			pst.setInt(2, age);
			pst.setString(3, education);
			pst.setString(4, gender);
			pst.setString(5, pass);
			flag = pst.executeUpdate();
			
		}
		
		if(flag != 0 ) {
			pst = conection.prepareStatement(query2);
			pst.setString(1,uname);
			pst.setString(2,pass);
			pst.execute();
			HttpSession session = request.getSession(true);
			session.setAttribute("username", uname);
			System.out.println("Inserted Successfully!!");
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
		}
		else
		{
			writer.print("<br>Signup failed! try again");
			RequestDispatcher rd = request.getRequestDispatcher("Signup.html");
			rd.include(request, response);
		}
			
		}catch (NumberFormatException e) {
			writer.print("Age should not be null or contain a character<br>");
			writer.print("<a href=\"Signup.html\">Back</a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		System.out.println(uname+pass+age+education+gender);
		DbUtil.closeConection(conection);
	
	
	}

}


/*
import java.io.IOException;
import utiltiy.DbUtil;
import utiltiy.Validate;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conection = null;
		ArrayList<String> errors = new ArrayList<String>();
		String uname="",confpass="",pass="",gender="",education="",query1="INSERT INTO userdetails VALUES(?,?,?,?,?)",query2="INSERT INTO logindetails VALUES(?,?)";
		int age=0,flag=0;
		PrintWriter writer = response.getWriter();
		PreparedStatement pst = null;
		response.setContentType("text/html");
		try {
		age = Integer.parseInt(request.getParameter("age"));
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		confpass = request.getParameter("confpass");
		education = request.getParameter("education");
		gender = request.getParameter("gender");
		
		System.out.println(uname+" "+pass+" "+age+" "+education+" "+gender);
		
		//errors = Validate.validatee(uname, pass, age, education, gender, confpass);

		if(uname == null || uname =="") {
			writer.print("Invalid Username! try again");
		}
		else if(pass == null || pass =="") {
			writer.print("Password cannot be null");
		}
		
		else if(!pass.equals(confpass)) {
			writer.print("Password and Confirm password do not match");
		}
		else if(age == 0) {
			writer.print("Age should not be null or have a character");
		}
		else {
			conection = DbUtil.createConnection("JSPreg");
			pst = conection.prepareStatement(query1);
			pst.setString(1, uname);
			pst.setInt(2, age);
			pst.setString(3, education);
			pst.setString(4, gender);
			pst.setString(5, pass);
			flag = pst.executeUpdate();
			
		}
		
		if(flag != 0 ) {
			pst = conection.prepareStatement(query2);
			pst.setString(1,uname);
			pst.setString(2,pass);
			pst.execute();
			System.out.println("Inserted Successfully!!");
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
		}
		else
		{
			writer.print("<br>Signup failed! try again");
			RequestDispatcher rd = request.getRequestDispatcher("Signup.html");
			rd.include(request, response);
		}
			
		}catch (NumberFormatException e) {
			writer.print("Age should not be null or contain a character<br>");
			writer.print("<a href=\"Signup.html\">Back</a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		System.out.println(uname+pass+age+education+gender);
		DbUtil.closeConection(conection);
	
	
	}

}
*/
