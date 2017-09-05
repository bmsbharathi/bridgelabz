<%@page import="java.io.PrintWriter"%>
<%@page import="utiltiy.DbUtil"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>
<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Bridgelabz</title>
<script>

</script>
</head>
<body>
<% 
	String sessionCheck,uname,pass;
	HttpSession session1 = request.getSession();
	sessionCheck = (String)session1.getAttribute("username");
	System.out.println(sessionCheck+"Session");
	System.out.println(session1);
	if(sessionCheck == null)
	{%>

	
	<script type="text/javascript">alert('Login First');</script>
	<%
	response.sendRedirect("index.html");
	/* rd.include(request,response); */
	}
	else{
		
		ResultSet rs = null;
		String query = "SELECT * FROM userdetails WHERE uname = ?";
		PreparedStatement pst = null;
		Connection conection = DbUtil.createConnection("JSPreg");
				
		pst = conection.prepareStatement(query);
		pst.setString(1, sessionCheck);
		rs = pst.executeQuery();
		
%>
<script type="text/javascript">alert('You are successfully Logged in');</script>
<h2><p align="right"><a href="index.html">Home</a></p></h2>
<h1>Hello <%= sessionCheck %>!</h1>
<div id="display">
<center>
<fieldset>
<legend>Personal Details</legend>
<br>
<br><% if(rs.next()){ %>

Username: <%= rs.getString("uname") %><br>
Age: <%= rs.getInt("age") %><br>
Gender: <%= rs.getString("gender") %><br>
Education:<%= rs.getString("education") %><br>
<br><br>
<%

}
session1.invalidate();
session1 = request.getSession(false);
System.out.println(session1);
DbUtil.closeConection(conection); 

}%>
</fieldset>
</center>
</div>
</body>
</html>