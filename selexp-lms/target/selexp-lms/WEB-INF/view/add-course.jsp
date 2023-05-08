<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>

<div class="container">

	<h1>Create Your New Course</h1>
	
	<form:form action="save-course" method="POST"
		modelAttribute="course">
		<label>Course Name :</label>
		<form:input path="course_name" />
		<br />
		<br/>
		<label>Course Duration:</label>
		<form:input path="course_duration" />
		<br />
		<br/>
		
		<label>Instructor Name</label>
		<form:select path="instructor.instructor_id">
		
		<form:options items="${instructorList}" itemLabel="instructor_name" itemValue="instructor_id"/>
		
		</form:select>
		<br/>
		<br/>
		<input type="submit" value="Add">

	</form:form>
	</div>

</body>
</html>