<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="updateCustomer" method="post">
<h1>Customer Edit</h1>
<table>
<tr>
<th>Id:</th><td><input type="text" value="${CustObj.custId}" name="custId" readonly="readonly"></td>
</tr>
<tr>
<th>Name:</th><td><input type="text" value="${CustObj.custName}" name="custName"></td>
</tr>
<tr>
<th>Email:</th><td><input type="text" value="${CustObj.custEmail}" name="custEmail"></td>
</tr>
<tr>
<th>Type:</th><td><c:choose><c:when test="${CustObj.custType eq 'seller'}"><select name="custType"><option value="seller">Seller</option><option value="consumer">Consumer</option></select></c:when><c:otherwise><select name="custType"><option value="consumer">Consumer</option><option value="seller">Seller</option></select></c:otherwise></c:choose></td>
</tr>
<tr>
<th>Address:</th><td><textarea name="custAddr">"${CustObj.custAddr}"</textarea></td>
</tr>
<tr>
<tr>
<th>products:</th><td><c:choose>
<c:when test="${CustObj.products eq 'Electronics'}"><input type="checkbox" name="products" value="Electronics" checked="checked">Electronics<input type="checkbox" name="products" value="Clothing" >Clothing<input type="checkbox" name="products" value="Home Appliances">Home Appliances<input type="checkbox" name="products" value="Books and More">Books and More</c:when>
<c:when test="${CustObj.products eq 'Clothing'}"><input type="checkbox" name="products" value="Electronics" >Electronics<input type="checkbox" name="products" value="Clothing" checked="checked">Clothing<input type="checkbox" name="products" value="Home Appliances">Home Appliances<input type="checkbox" name="products" value="Books and More">Books and More</c:when>
<c:when test="${CustObj.products eq 'Home Appliances'}"><input type="checkbox" name="products" value="Electronics" >Electronics<input type="checkbox" name="products" value="Clothing" >Clothing<input type="checkbox" name="products" value="Home Appliances" checked="checked">Home Appliances<input type="checkbox" name="products" value="Books and More">Books and More</c:when>
<c:otherwise>
<input type="checkbox" name="products" value="Electronics" >Electronics<input type="checkbox" name="products" value="Clothing">Clothing<input type="checkbox" name="products" value="Home Appliances">Home Appliances<input type="checkbox" name="products" value="Books and More" checked="checked">Books and More

</c:otherwise>
</c:choose></td>
</tr>
<tr>
<th>Shipping Type:</th>
<td><c:if test="${CustObj.shippingtype eq 'Airway'}"><select name="shippingtype"><option value="Airway" selected="selected">Airway</option><option value="Waterway">WaterWay</option><option value="Railway">RailWay</option><option value="Roadway">RoadWay</option></select></c:if>
<c:if test="${CustObj.shippingtype eq 'Railway'}"><select name="shippingtype"><option value="Railway" selected="selected">Railway</option><option value="Waterway">WaterWay</option><option value="Airway">Airway</option><option value="Roadway">RoadWay</option></select></c:if>
<c:if test="${CustObj.shippingtype eq 'Roadway'}"><select name="shippingtype"><option value="Roadway" selected="selected">Roadway</option><option value="Waterway">WaterWay</option><option value="Railway">RailWay</option><option value="Airway">AirWay</option></select></c:if>
<c:if test="${CustObj.shippingtype eq 'Waterway'}"><select name="shippingtype"><option value="Waterway" selected="selected">Waterway</option><option value="Airway">AirWay</option><option value="Railway">RailWay</option><option value="Roadway">RoadWay</option></select></c:if>
</td>
</tr>
<tr>
<tr><th>Transport</th><td><select name="transport.transportId" multiple><option value="-1">--select--</option><c:forEach items="${TransportData}" var="trans"><c:choose><c:when test="${CustObj.transport.transportId eq trans.transportId }"><option value="${trans.transportId}" selected="selected"><c:out value="${trans.transportSource}"></c:out></option></c:when><c:otherwise><option value="${trans.transportId}"><c:out value="${trans.transportSource}"></c:out></option></c:otherwise></c:choose></c:forEach></select></tr>

<%--  <tr><th>Transport</th><td><select name="transport.transportId"><option value="-1">--select--</option><c:forEach items="${TransportData}" var="trans"><c:if test="${CustObj.transport.transportId eq trans.transportId}"><option value="${trans.transportId}" selected="selected"><c:out value="${trans.transportSource}"></c:out></option></c:if><option value="${trans.transportId}"><c:out value="${trans.transportSource}"></c:out></c:forEach></select></td></tr>
 --%>
<tr><td colspan="2"><input type="submit" value="update"></td></tr>
</table>
<pre>
</pre>
</form>
</body>
</html>