<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel = "stylesheet"
  href = "${pageContext.request.contextPath}/resources/css/style.css">
  
<meta charset="ISO-8859-1">
<title>Customer-List</title>
</head>
<body>

<div id = "header">
<h2> Customer Relationship Manager Application </h2>
</div>

<br>

<input type = button value = "Add New Customer" class = 'add-button' 
 onClick = "window.location.href ='addCustomer'">
<br><br>



<div margin-left = "20px">

<table border ="1">
<th><h3> First Name</h3> </th>
<th><h3> Last Name </h3></th>
<th><h3> Email </h3></th>
<th><h3> Action </h3></th>

      
 <c:forEach items="${customer}" var = "temp">

<c:url var= "updateLink" value="updateCustomer">
  <c:param name="customerId" value="${temp.id}"></c:param>
</c:url>

<c:url var = "deleteLink" value= "deleteCustomer">
   <c:param name="customerId" value= "${temp.id}"></c:param>
</c:url>
 <tr>
    <td>${temp.firstName}</td>
    <td>${temp.lastName}</td>
    <td>${temp.email}</td>
    <td>
        <a href = "${updateLink}">Update it </a>
        |
        <a href= "${deleteLink}" onClick="if(!(confirm('Do you really Want to delete the customer ?'))) return false"> Delete it </a>
     </td>
    
    <!-- another way of adding link -->
   <%--  <td><a href = "updateCustomer?id=${temp.id}"> Update </a> --%>
    
 
    
 </tr>
 
 
 </c:forEach>

</div>

</table>
</body>
</html>