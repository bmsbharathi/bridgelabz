

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utiltiy.DataAccess;
import utiltiy.DbUtil;

import java.sql.Statement;



@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("username");
		System.out.println(uname);
		ResultSet rs = null;
		DataAccess da = new DataAccess();
		Connection conn = null;
		try {
			conn = utiltiy.DbUtil.createConnection("JSPreg");
			Statement st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM userdetails WHERE uname = '"+uname+"'");
			//System.out.println("SELECT * FROM userdetails WHERE uname = '"+uname+"'");
			
			while(rs.next()) {
				da.setUname(rs.getString(1));
				da.setAge(Integer.parseInt(rs.getString(2)));
				da.setEducation(rs.getString(3));
				da.setGender(rs.getString(4));
				da.setEmail(rs.getString(5));
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
			}
			session.setAttribute("Data", da);
			//session.setAttribute("data", da);
			System.out.println(da.getAge()+da.getEducation()+da.getUname()+da.getGender());
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{

			DbUtil.closeConection(conn);
		}
	}

}
