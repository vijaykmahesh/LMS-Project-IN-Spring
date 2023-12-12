<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Login Here</h1>
<hr/>

<c:if test="${param.error != null}">  
  <p align="center" style="color: red;"> <i>invalid username or password</i> </p>
</c:if>

<c:if test="${param.logout != null}">  
  <p align="center" style="color: blue;"> <i>you have been scuessfully logged out</i> </p>
</c:if>


<div align="center">
	<form action="process-login" method="POST">
	Username: <input type="text" name="username"> 
	<br/>
	<br/>
	
	password: <input type="password" name="password"> 
	<br/>
	<br/>
	<input type="submit" value="login">
	</form>
</div>
</body>
</html>