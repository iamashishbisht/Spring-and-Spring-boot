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
Hi Guys this is  a home page!!
</div>
<hr>
<div>
User : <security:authentication property="principal.username"/>
<br>
Role : <security:authentication property="principal.authorities"/>
</div>
<hr>
<hr>

<!-- to show the content omly to manager -->
<security:authorize access = "hasRole('MANAGER')">
For<a href ="<%=request.getContextPath()%>/manager" > Manager </a> only link.
</security:authorize>
<br>

<security:authorize access="hasRole('ADMIN')">
For<a href ="<%=request.getContextPath()%>/admin" > Admin </a> only link.
<hr>
</security:authorize>

<form:form action= "logout" method= "POST">
<input type = "submit" value = "logout"/>

</form:form>


</body>
</html>