<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#custId").change(function(){
		$.ajax({
			url:'checkId',
			data:{eid:$("#custId").val()},
			success:function(resTxt){
				$("#errmsg").text(resTxt);
				if(resTxt!=""){
					$("#custId").val("");
					$("#custId").focus();
				}
					
			}
		});
	});
});
</script>

</head>
<style>
.center{
margin:auto;
width:60%;
border:2px solid #73AD21;
padding:10px;
}
</style>
<body>
<%@ include file="Master.jsp" %>
<form action="insertCust" method="post">
<div class="center">
<h1 align="center">Customer Registration</h1>
<table>
<tr><th>Id</th><td><input type="text" name="custId" id="custId"/><span id="errmsg"></span> </td></tr>
<tr><th>Name</th><td><input type="text" name="custName"></td></tr>
<tr><th>Email</th><td><input type="text" name="custEmail"></td></tr>
<tr><th>Type</th><td><select name="custType"><option value="-1">--Select--</option><option value="SELLER">Seller</option><option value="CONSUMER">Consumer</option></select></td></tr>
<tr><th>Address</th><td><textarea rows="4" cols="15" name="custAddr"></textarea></td></tr>
<tr><th>Products</th><td><input type="checkbox" name="Products" value="Electronics">Electronics
<input type="checkbox" name="Products" value="Clothing">Clothing
<input type="checkbox" name="Products" value="Home Appliances">Home Appliances
<input type="checkbox" name="Products" value="Books and More">Books and More</td></tr>
<tr><th>Shipping Type</th><td><select name="Shippingtype"><option value="-1">--select--</option><option value="Airway">AirWay</option><option value="Roadway">RoadWay</option><option value="Waterway">WaterWay</option><option value="Railway">RailWay</option></select></td></tr>
<tr><th>Transport Type</th><td><select name="transport.transportId"><option value="-1">--select--</option><c:forEach items="${TransportData}" var="t"><option value="${t.transportId}"><c:out value="${t.transportSource}"></c:out></option></c:forEach></select></td></tr>
<tr><td colspan="2"><input type="submit" value="Submit" name="btn3"></td></tr>
</table>
</div>
</form>
${m}
</body>
</html>