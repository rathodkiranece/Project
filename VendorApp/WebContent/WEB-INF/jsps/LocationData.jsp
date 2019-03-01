<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Data Page</h1>

<table border="1">
 <tr>
 	<th>Id</th><th>Name</th><th>Type</th>
 </tr>
<c:forEach items="${locListObj}" var="loc">
<tr>
 <td><a href='showEditLoc?locId=<c:out value="${loc.locId}"/>'><c:out value="${loc.locId}"/></a></td>
 <td><c:out value="${loc.locName}"/></td>
 <td><c:out value="${loc.locType}"/></td>
 <td><a href='deleteLoc?locId=<c:out value="${loc.locId}"/>'onclick="return confirmfun()"><img src="../images/trash.png" width="15" height="15"/></a></td>
</tr> 
</c:forEach>
</table>
</body>
</html>