<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin module</title>
</head>
<body>
<h2>Admin Home Page </h2>
<button class="dropbtn">Admin</button>
<div class="dropdown-content">
<a href="viewAdmins">View Admins</a> <a href="userReg"> Creaete Admin By Reg</a>
</div>
<a href="viewUsersType">All users</a>
<a href="userLogout">Logout</a><br>
${message}
</body>
</html>