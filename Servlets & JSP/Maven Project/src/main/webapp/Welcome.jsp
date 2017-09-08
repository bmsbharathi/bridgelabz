<%@page import="utiltiy.DataAccess"%>
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
	String uname,pass;
	session = request.getSession();
	uname = (String)session.getAttribute("username");
	System.out.println(uname+"Session");
	System.out.println(session);
	if(uname == null)
	{%>

	
	<script type="text/javascript">alert('Login First');</script>
	<%
	response.sendRedirect("index.jsp");
	/* rd.include(request,response); */
	}
	else{
		DataAccess da = (DataAccess)session.getAttribute("Data");
		//out.println(da.getUname());
		/* out.println(request.getAttribute("Data")); */
				
%>
<script type="text/javascript">alert('You are successfully Logged in');</script>
<h2><p align="right"><a href="logout">Logout</a></p></h2>
<h1>Hello <%= da.getUname() %>!</h1>
<div id="display">
<center>
<fieldset>
<legend>Personal Details</legend>
<br>
<br>

Username: <%= da.getUname() %><br>
Age: <%= da.getAge() %><br>
Gender: <%= da.getGender() %><br>
Education:<%= da.getEducation() %><br>
Email:<%= da.getEmail() %><br>
<br><br>
<%

}%>
</fieldset>
</center>
</div>
</body>
</html>