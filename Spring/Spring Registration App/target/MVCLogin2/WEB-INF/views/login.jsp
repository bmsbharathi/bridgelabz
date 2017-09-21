<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Here</title>
</head>
<body>
	<h1 align="center">Login Form</h1>
	<form:form name="Login" commandName="loginuser" action="login"
		method="POST">
		<form:label path="username" />Username
		<form:input path="username" />
		<form:errors path="username" />
		<br>
		<br>
		<br>
		<form:label path="password" />Password
		<form:password path="password" name="password" />
		<form:errors path="password" />
		<br>
		<br>
		<br>
		<div>${message}</div>
		<input type="submit" value="Login">&nbsp;&nbsp;&nbsp;<a href="forgotPass">Forgot Password</a>
		<br>
		<br>
		<br>
		<a href="Register">I am a New User!</a>
	</form:form>
</body>
</html>