<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action= "customerProcessForm" modelAttribute="theCustomer">
first Name : <form:input path= "firstName" />

<br><br>

Last Name ** : <form:input path="lastName"/>
<form:errors path= "lastName" />

<br><br>

free Passes : <form:input path="freePasses"/>
<form:errors path= "freePasses"/>
<br><br>
Postal code: <form:input path= "postalCode"/>
<form:errors path = "postalCode" cssClass="color"/>
<br><br>

EmployeeId: <form:input path= "employeeId"/>
<form:errors path = "employeeId" cssClass="color"/>
<br><br>

<input type = "submit" value= "Submit Customer Form">

</form:form>
</body>
</html>