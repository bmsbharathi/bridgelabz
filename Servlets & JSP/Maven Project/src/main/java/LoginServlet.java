

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utiltiy.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname="",pass="",gender="",education="",query="SELECT * FROM logindetails WHERE uname =? AND pass =?";
		int age=0;
		PrintWriter writer = response.getWriter();
		Connection conection = null;
		try {
			conection = DbUtil.createConnection("JSPreg");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		PreparedStatement pst = null;
		boolean flag;
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		String passHash="";
		try {
		
			uname = request.getParameter("uname");
			pass = request.getParameter("pass");
			
			MessageDigest md =  MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			byte[] passBytes = md.digest();
			StringBuilder sb = new StringBuilder();
	        for(int i=0; i< passBytes.length ;i++)
	        {
	            sb.append(Integer.toString((passBytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        passHash = sb.toString();
	        
			System.out.println(passHash);
			
			pst = conection.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, passHash);
			rs = pst.executeQuery();
			
			
			if(rs.next()) {
				session.setAttribute("username", uname);
				System.out.println("Logged in Successfully!!");
				response.sendRedirect("welcome");
				/*RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
			*/
			}
			else
			{
				
				writer.print("<script>alert('Login failed! try again');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("error", "Invalid Credentials! try again");
				rd.forward(request, response);
				//response.sendRedirect("index.jsp");
			}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally{

				DbUtil.closeConection(conection);
			}
	
	}

}
