<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<div>
Hi Guys this is  a Admin only page!!
<br>
lets go for a holiday and don't tell about this to the regular employee
</div>
<hr>


<a href = "<%= request.getContextPath() %>/"> Back to home Page</a>


<form:form action= "logout" method= "POST">
<input type = "submit" value = "logout"/>

</form:form>


</body>
</html>