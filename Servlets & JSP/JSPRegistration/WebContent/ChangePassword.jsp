<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="utiltiy.DbUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
response.setContentType("text/html");
String pass = request.getParameter("pass");
String passhash;
String uname = request.getParameter("uname"); 
response.setContentType("text/html");

System.out.println(pass+uname);
%>
<body><center>
<%
if( pass==null){
	out.print("<h3>Update the password</h3>");
} 
else{
	MessageDigest md =  MessageDigest.getInstance("MD5");
	md.update(pass.getBytes());
	byte[] passBytes = md.digest();
	StringBuilder sb = new StringBuilder();
    for(int i=0; i< passBytes.length ;i++)
    {
        sb.append(Integer.toString((passBytes[i] & 0xff) + 0x100, 16).substring(1));
    }
    passhash = sb.toString();
    System.out.println(passhash+"  "+uname);
	Connection conection = DbUtil.createConnection("JSPreg");
	System.out.print("");
	String query = "UPDATE userdetails SET pass=? WHERE uname=?",query1 = "UPDATE logindetails SET pass=? WHERE uname = ?";
	PreparedStatement pst = conection.prepareStatement(query);
	pst.setString(1,passhash);
	pst.setString(2, uname);
	pst.execute();
	
	pst = conection.prepareStatement(query1);
	pst.setString(1,passhash);
	pst.setString(2, uname);
	if(!pst.execute())
	{
	String message = "Password Successfully Updated";
	//out.write("<script>window.location=\"http://localhost:8080/JSPRegistration/index.jsp?error=Successfully_updated_password\";</script>");	
	response.sendRedirect("index.jsp?error="+message);
	}
	
}
%>
<form method="post" action="ChangePassword.jsp">
<input type="password" name="pass">
<input type="hidden" name="uname" value="<%=uname%>">
<input type="submit" name="Update password">
</form>
</center>
</body>
</html>