

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utiltiy.DbUtil;
import java.util.Random;

@WebServlet("/forgotpass")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String code = request.getParameter("code");
    	String uname = request.getParameter("uname");
    	String sentCode = request.getParameter("genCode");
    	response.setContentType("text/html");
    	PrintWriter writer = response.getWriter();
    	System.out.println(uname+"  "+code+"   "+sentCode);
    	if( code.equals(sentCode)) {
    		RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
    		rd.forward(request, response);
    	}
    	else {
    		//PrintWriter writer1 = response.getWriter();
    		writer.print("Code doesn't match Try again!");
    		RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
    		rd.include(request, response);
    	}
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String uname = request.getParameter("uname"),query="SELECT email FROM userdetails WHERE uname = '"+uname+"' ",email="";
		response.setContentType("text/html");
		Connection conection = null;
		ResultSet rs = null;
		Statement st = null;
		String OTP;
	    try{
	    	conection = DbUtil.createConnection("JSPreg");
	    	st = conection.createStatement();
	    	rs = st.executeQuery(query);
	    	while(rs.next()) {
	    		email = (String)rs.getString(1);
	    	}
			System.out.println(email);
			
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true"); 
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", "465");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");

	        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
	        	
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("bmsbharathi@gmail.com", "PASSWORD" );
	            }
	        });

	        mailSession.setDebug(true); // Enable the debug mode

	        Message msg = new MimeMessage( mailSession );

	        //--[ Set the FROM, TO, DATE and SUBJECT fields
	        msg.setFrom( new InternetAddress( "bmsbharathi@gmail.com" ) );
	        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email) );
	        msg.setSentDate( new Date());
	        msg.setSubject( "Password Reset" );
	        Random rand = new Random();
	        //--[ Create the body of the mail
	        OTP=""+rand.nextInt(334234233);
	        msg.setText( "Your OTP: "+OTP );
	        System.out.println(OTP+"  "+uname);
	        /*request.setAttribute("uname", uname);
        	request.setAttribute("genOTP", OTP);*/
	        //--[ Ask the Transport class to send our mail message
	        Transport.send( msg );
	        if(OTP!=null) {
	        	System.out.println("Check Your mail!");
	        	writer.print("<center><h3>Check Your mail for the One Time Password!</h3><br><form method=\"get\" action=\"forgotpass\">");
	        	writer.print("<input type=\"text\" name=\"code\">");
	        	writer.print("<input type=\"hidden\" name=\"genCode\" value='"+OTP+"'>");
	        	writer.print("<input type=\"hidden\" name=\"uname\" value='"+uname+"'>");
	        	writer.print("<input type=\"submit\"></form></center>");
	        }
	        
	        
	        

	    }catch(SQLException E){
	        System.out.println( "Oops something has gone pearshaped!");
	        System.out.println( E );
	        response.sendRedirect("ForgotPassword.jsp?error=Invalid_mail_id");
	    } catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println( "Oops something has gone pearshaped!");
	        System.out.println( e );
	        response.sendRedirect("ForgotPassword.jsp?error=Invalid_mail_id");
		}
	}

}
