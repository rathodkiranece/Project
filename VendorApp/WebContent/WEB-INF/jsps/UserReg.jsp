<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Master.jsp"%>
<h1> welcome to User Register Page!!</h1>
<form action="insertUser" method="post">
<pre>
Name 	:<input type="text" name="userName"/>
UserType:<select name="userType">
<option value="-1">select</option>
<option value="user">User</option>
<option value="admin">Admin</option>
</select>
Email 	:<input type="text" name="userEmail"/>
Mobile 	:<input type="text" name="userContact"/>
Address	:<textarea name="userAddr"></textarea>
<input type="submit" value="Register"/>
</pre>
</form>
${msg}<br/>
*SingIn? click <a href="showLogin">Here</a>
</body>
</html>