<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BridgeLabz LLP</title>
</head>
<body>
<%

	 	if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
		} 
		
		%>
	<h1>BridgeLabz</h1>
	<fieldset>
		<legend>Login</legend>
		
		<center>
		<%
		if(request.getParameter("error")!=null){
			out.println(request.getParameter("error"));
		}
		%>
		<form method="post" action="login">
		<br><br>
			Username:&nbsp;&nbsp;<input type="text" name="uname"><br><br>
			Password:&nbsp;&nbsp; <input type="password" name="pass"><br><br>
			<input type="submit" value="Login"><br><br>
			<a href="ForgotPassword.jsp">Forgot Password</a>
			<br><br>
		</form>
		<p align="right"><a href="Signup.jsp">New User?</a></p>
	</fieldset>
	</center>
	<%-- <%
	ServletContext ctx = request.getServletContext();
	out.print(ctx.getAttribute("Test"));
	%> --%>
</body>
</html>