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
<form:form action= "processFormV3" modelAttribute= "theStudent">

First Name : <form:input path="firstName"/>
<br><br>
Last Name : <form:input path="lastName"/>
<br>
<br>

<form:select path="dropdown">
<form:option value="C++" />
<form:option value="JAVA" />
<form:option value="PYTHON" />
<form:option value="PHP" />
</form:select>

<form:select path="drop">
<form:options items="${theStudent.dropdown2}" />
</form:select>
<br><br>

php : <form:radiobutton path="myButton" value="php"/>
c++ : <form:radiobutton path="myButton" value = "c++"/>
java : <form:radiobutton path="myButton" value = "java"/>

<br><br>

Checkbox:
india :<form:checkbox path="myCheckbox" value = "india"/>
US :<form:checkbox path="myCheckbox" value = "US"/>
Germany :<form:checkbox path="myCheckbox" value = "Germany"/>
France : <form:checkbox path="myCheckbox" value = "France"/>

<br><br>
<input type= "submit" value =  "Submit name">

</form:form>

</body>
</html>