<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Location Module</title>
<style type="text/css" >
#heading{
color: red;
}
#data{
color: olive;
}
h2{
color: orange;
}
</style>
</head>
<body>
<%@ include file="Master.jsp"%>
<h2>ALL Users Data</h2>
<table border="1" bordercolor="lime" >
<tr id="heading">
<th>UserId</th><th>Name</th><th>Address</th><th>UserStatus</th><th colspan="1">Operations</th>
</tr>
<c:forEach items="${userTypeList}" var="userTypeObj">
<tr id="data">
<td><c:out value="${userTypeObj.userId}"/></td>
<td><c:out value="${userTypeObj.userName}"/></td>
<td><c:out value="${userTypeObj.userAddr}"/></td>
<c:choose>
<c:when test="${userTypeObj.userType eq 'user' and userTypeObj.status eq 0}">
<td><a href = 'makeActive?userId=<c:out value="${userTypeObj.userId}"/>'>Active</td>
</c:when>

<c:when test="${userTypeObj.userType eq 'user' and userTypeObj.status eq 1}">
<td><a href = 'makeDeActive?userId=<c:out value="${userTypeObj.userId}"/>'>DeActive</td>
</c:when>

</c:choose>

<td width="30"><a href='deleteUser?userId=<c:out value="${userTypeObj.userId}"/> '><img src="../images/trash.png" height="15" width="15"></a></td>
<%-- <td><a href='editUser?userId=<c:out value="${userObj.userId}"/> '>Edit Rec</a></td>
 --%></tr>
</c:forEach>
</table>
<br>
${msg}
</body>
</html>