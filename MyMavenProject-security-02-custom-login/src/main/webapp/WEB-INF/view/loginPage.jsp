<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<h2>Custom Login Form </h2>


<form:form action= "authenticateUser" Method = "POST">

<c:if test = "${param.error != null}" >
<i>Username and Password doesn't match</i>
</c:if>
<br>

Username : <input  type = "text" name="username" />
</br>
Password : <input type = "password" name= "password" />
</br>
</br>
<input type = "submit" value ="Login"/>
</form:form>



</body>
</html>