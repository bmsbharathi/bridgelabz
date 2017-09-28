<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
Author: B.M.S.Bharathi

Created On: 25 Sep 2017

Description: A simple Registration App developed using Spring MVC. The App also provides a social Login feature using
Google + login.

 --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<%-- 	<center style="color: green;">
		<b>${Success}</b>
	</center>
	<center style="color: red;">
		<b><b>${failure}</b></b>
	</center>
	 --%>
	<h1>Login Here</h1>
	<fieldset>
		<legend>Login</legend>

		<form:form method="post" action="checkUser" commandName="loginuser">
			<table>

				<tr>
					<td><form:label path="email" />Email:</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" /></td>
				</tr>

				<tr>
					<td><form:label path="password" />Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr></tr>

				<tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" Value="LOGIN"></td>
				</tr>
			</table>
			<br>
			<br>
			<a href="register">I am a New User</a>
		</form:form>
		<br> <br>

		<button type="button" onClick=window.location="googleLogin">Google+</button>
	</fieldset>

</body>
</html>