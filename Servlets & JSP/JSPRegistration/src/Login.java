

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		Connection conection = DbUtil.createConnection("JSPreg");
		ResultSet rs = null;
		PreparedStatement pst = null;
		boolean flag;
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		
		try {
		
			uname = request.getParameter("uname");
			pass = request.getParameter("pass");
			
			pst = conection.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			session.setAttribute("username", uname);
			
			if(rs.next()) {
				
				System.out.println("Logged in Successfully!!");
				response.sendRedirect("Login.jsp");
				/*RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
			*/
			}
			else
			{
				
				writer.print("<script>alert('Login failed! try again');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			//System.out.println(uname+pass+age+education+gender);
			DbUtil.closeConection(conection);
		
	
	}

}
