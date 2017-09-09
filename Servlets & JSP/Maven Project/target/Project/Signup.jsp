<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BridgeLabz LLP</title>
</head>
<body>
	<h1>BridgeLabz LLP</h1>
	<fieldset>
		<legend>Sign Up</legend>
		<center>
		<form method="post" action="signup">
		<br><br>
		<table>
			<tr><td>Username:</td><td>  </td>  <td></td><td><input type="text" name="uname" required></td></tr>
			<tr><td>Age:</td><td>  </td><td> </td><td><input type="text" name="age" required></td></tr>
			<tr><td>Gender:</td><td>  </td><td> </td><td><input type="radio" name="gender" value = "male" required>Male</td><td><input type="radio" name="gender" value = "female">Female</td></tr>
			<tr><td>Education Qualification</td><td></td><td>  </td><td><select name="education" required><option value="Graduate">Graduate</option><option value="Post Graduate">Post Graduate</option><option value="Diploma">Diploma</option></select></td></tr>
			<tr><td>Password:</td><td>  </td>  <td></td><td><input type="password" name="pass" required></td></tr>
			<tr><td>Confirm Password:</td><td>  </td>  <td></td><td><input type="password" name="confpass"  required></td></tr>
			<tr><td>Email:</td><td>  </td>  <td></td><td><input type="text" name="email"  required></td></tr>
			<tr></tr>
			<tr><td></td><td><input type="submit" value="Signup"></td></tr>
		</table>
		</form>
		<p align="right"><a href="index.jsp">Go To Login page</a></p>
	</center>
	</fieldset>
	
</body>
</html>