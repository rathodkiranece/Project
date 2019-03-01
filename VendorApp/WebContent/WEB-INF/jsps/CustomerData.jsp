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
<title>Customer Registration</title>
<style type="text/css">
table{
border-collapse:collapse;
width=80%;
}
th,td{
padding:8px;
text-align:left;
border-bottom:1px solid #ddd;
}
tr:hover{
background-color:#f5f5f5
}

</style>
</head>
<body>
<%@include file="Master.jsp" %>
<h1>Customer Data</h1>
<table border="1">
<tr><th>Customer ID</th><th>Customer Name</th><th>Email</th><th>Type</th><th>Address</th><th>Products</th><th>Shipping Type</th><th>Transport</th><th colspan="2">Operation</th></tr>
<c:forEach items="${custListObj}" var="cust">
<tr>
<td><c:out value="${cust.custId}"></c:out></td>
<td><c:out value="${cust.custName}"></c:out></td>
<td><c:out value="${cust.custEmail}"></c:out></td>
<td><c:out value="${cust.custType}"></c:out></td>
<td><c:out value="${cust.custAddr}"></c:out></td>
<td><c:out value="${cust.products}"></c:out></td>
<td><c:out value="${cust.shippingtype}"></c:out></td>
<td><c:out value="${cust.transport.transportSource}"></c:out></td>
<td><a href='showEditCust?custId=<c:out value="${cust.custId}"/>'>Edit</a></td>
<td><a href='deleteCust?custId=<c:out value="${cust.custId}"/>'onclick="return confirmfun()">
<img src="../images/trash.png" width="15" height="15"/></a></td>
<td><a href='showCustItem?custId=<c:out value="${cust.custId}"/>'>View Items</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>