<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel = "stylesheet"
  href = "${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add New Customer</h2>


<form:form action="saveCustomer" method="GET" modelAttribute = "customer" >

<form:hidden path="id"/>
<table>

<tr>
<td>First Name :</td> <td><form:input path="firstName"/></td>
</tr>

<tr>
<td>Last Name : </td><td><form:input path="lastName"/></td>
</tr>


<tr>
<td>Email :</td><td> <form:input path="email"/></td>
</tr>

</table>

<input type = "submit" value = "Save" class="save">

</form:form>
<br><br>
<a href= "list">Back </a>
<br><br>
</div>
</body>
</html>