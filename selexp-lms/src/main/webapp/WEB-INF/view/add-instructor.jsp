<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="menu.jsp"%>

	
	
	<div class="container">

	<h1>Add Instructor</h1>
	
	<form:form action="submit-instructor" method="POST"
		modelAttribute="instructor">
		<label>Name :</label>
		<form:input path="instructor_name" />
		<br />
		<br />
		<label>Teaching Exp :</label>
		<form:input path="instructor_training_exp" />
		<br />
		<br />
		<label>Email :</label>
		<form:input path="instructor_email" />
		<br />
		<br />
		<input type="submit" value="Add">

	</form:form>
	</div>

</body>
</html>