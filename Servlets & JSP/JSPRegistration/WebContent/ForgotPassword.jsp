<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>
</head>
<body>
<center>
<h1>Forgot Password</h1>
<form method="post" action="forgotpass">
Enter the Username<br><br><input type="text" name="uname"><br><br>
<input type="Submit" name="Reset Password">
</form>
<%
	if(request.getParameter("error")!=null){
		out.print(request.getParameter("error"));
	}
%>
</center>
</body>
</html>