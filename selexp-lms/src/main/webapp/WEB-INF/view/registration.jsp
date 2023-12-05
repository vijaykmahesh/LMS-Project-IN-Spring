<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration form</title>
</head>
<body>

 <form:form action="process-registration" method="POST" modelAttribute="reg">
   
  Username:  <form:input type="text" path="username" name="user"/>
  <br/>
  Password:  <form:input type="text" path="password" name="pass" />
  <br/>
  <input type="submit" value="register">
  
  
 
 
 </form:form>

</body>
</html>