<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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

<form action= "authenticateUser" Method = "POST">

	<%-- 
	<c:if test="${param.logout != null}">
	<p>You have been logged out.</p>
	</c:if>
	 --%>
<%
if (request.getParameter("error") != null){
%>
	<i>Invalid username and password.</i>
<% } %>
	<%-- 
	<c:if test = "${param.error != null}" >
	out.println("halla bol");
	<p>Username and Password doesn't match</p>
	</c:if>
	 --%>

<%
if (request.getParameter("logout") != null){
%>	
	<i>you have been logged out from the session.</i>
<% } %>	
		 
<br><br>

Username : <input  type = "text" name="username" />
</br>
Password : <input type = "password" name= "password" />
</br>
</br>
<input type = "submit" value ="Login"/>

<!-- manually adding tokens if not using form:form -->

<input type ="hidden"
       name = "${_csrf.parameterName}"
       value = "${_csrf.token}" />
       
 
</form>



</body>
</html>