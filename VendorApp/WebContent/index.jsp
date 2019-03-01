<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here </title>
</head>
<body>
<footer>
<center>Welcome to Home</center>
</footer>
<br>
<center><a href="mvc/showLogin">Login Page</a>
<br>
<%=new java.util.Date()%>
<%response.setHeader("Refresh","1"); %>
</center>
</body>
</html>