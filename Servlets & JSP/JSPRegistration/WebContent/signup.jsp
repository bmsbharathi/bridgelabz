<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Bridgelabz</title>
<script>
function display(){
	var age= '<%= request.getParameter("age") %>';
	var education= '<%= request.getParameter("education") %>';
	var gender= '<%= request.getParameter("gender") %>';
	var username= '<%= request.getParameter("uname") %>';
	document.getElementById("display").innerHTML='<center>'+"Username: "+username+'<br><br>'+"Age: "+age+'<br><br>'+"Gender: "+gender+'<br><br>'+"Education: "+education+'</center>';
}
</script>
</head>
<body>
<%
String sessionCheck;
HttpSession session1 = request.getSession();
sessionCheck = (String)session1.getAttribute("username");
if(sessionCheck == null){
%>
<script type="text/javascript">alert('Go to Signup Page');
//window.location="http://localhost:8085/JSPRegistration/Signup.html";
</script>
<%
/*  RequestDispatcher rd = request.getRequestDispatcher("Signup.html");
rd.include(request,response);  */
response.sendRedirect("Signup.html");
}
else{%>

<script type="text/javascript">alert('You are successfully Signed Up & Logged in');</script>
<h2><p align="right"><a href="index.html">Home</a></p></h2>
<h1>Hello <%= request.getParameter("uname") %></h1>
<div id="display">
<br>
<center><button onclick="display();"><b>Show Details</b></button></center></div>
</body><%
session1.invalidate();
}
%>

</html>