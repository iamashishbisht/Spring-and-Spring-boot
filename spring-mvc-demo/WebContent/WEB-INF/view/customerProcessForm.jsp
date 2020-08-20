<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer process form</title>
</head>
<body>
first Name : ${theCustomer.firstName}
<br><br>
Last Name is : ${theCustomer.lastName}
<br><br>

Free passes : ${theCustomer.freePasses}
<br><br>

Postal Code is : ${theCustomer.postalCode}
<br><br>

Employee Id is : ${theCustomer.employeeId}
<br><br>

<form:form modelAttribute="theCustomer">
first Name : <form:input path= "firstName" />

<br><br>
last Name : <form:input path= "lastName" />
</form:form>

</body>
</html>