 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<a href="?lang=en">English</a>
<a href="?lang=hi">Hindi</a>
<a href="?lang=te">Telugu</a>
<a href="?lang=kn">Kannada</a>
<a href="?lang=ta">Tamil</a>
<a href="?lang=bn">Bengali</a>

<%@include file="Master.jsp"%>
<h1><spring:message code="title"/></h1>
<script type="text/javascript" src="../scripts/javascript.js"></script>
<script type="text/javascript" src="../scripts/validator.js"></script>
<form name="locForm" action="insertLoc" method="post" onsubmit="return validateLoc();">
                                  <pre>
<spring:message code="locIdMsg"/>:<input type="text" name="locId" id=locId /><span  id="errmsg" ></span> <span id="locIdErr" class="error"> </span>
<spring:message code="locNameMsg"/>	: <input type="text" name="locName"/><span id="locNameErr" class="error"></span>
<spring:message code="locTypeMsg"/>	: <input type="radio" name="locType" value="Urban"/>Urban<input type="radio" name="locType" value="Rural"/>Rural <span id="locTypeErr" class="error"></span>
                                    <input type="submit" value="Submit"/>
                                 </pre>
</form>
${msg}
</body>
</html>

