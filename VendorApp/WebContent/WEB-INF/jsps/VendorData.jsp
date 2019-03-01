<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function confirmfun()
{ var v=confirm(" Are you Sure you want to delete")
	if(v)
		{
		return true;
		}
	else {
		return false;
	}
	}

</script>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Vendor Data Page!!</h1>
<a href="exportLocToExcel">Export Data(Excel)</a><br/>
<a href="exportLocToPdf">Export Data(PDF)</a>

<table border="1">
<tr>
 <th>Id</th><th>Name</th><th>Email</th><th>Mobile</th><th>Address</th><th>Location name</th><th>Location type</th>
</tr>
<c:forEach items="${venListObj}" var="ven">
<tr>
<td><a href='showEditVen?venId=<c:out value="${ven.venId}"/>'><c:out value="${ven.venId}"/></a></td>
<td><c:out value="${ven.venName}"/></td>
<td><c:out value="${ven.venMail}"/></td>
<td><c:out value="${ven.mobile}"/></td>
<td><c:out value="${ven.address}"/></td>
<td><c:out value="${ven.loc.locName}"></c:out></td>
<td><c:out value="${ven.loc.locType}"></c:out></td>
<td><a href='deleteVen?venId=<c:out value="${ven.venId}"/>'onclick="return confirmfun()">
<img src="../images/trash.png" width="15" height="15"/></a></td>
</tr>
</c:forEach>
</table>
</body>
</html>