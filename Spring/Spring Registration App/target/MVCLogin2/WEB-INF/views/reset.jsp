<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
</head>
<body>
<form method="post" action="updatePass">
<center>
<h2>Check Your mail for OTP</h2>
<div>${message}</div>
<form method="post" action="newPass">
<input type="text" name="genCode">

<input type="Submit" value="Enter OTP!">
</form>
</center>
</body>
</html>