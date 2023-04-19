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

	<h1>Create Your New Lesson</h1>
	
	<form:form action="save-lesson" method="POST"
		modelAttribute="lesson">
		
		<form:hidden path="course.course_id"/>
		
		<label>Lesson Name :</label>
		<form:input path="lesson_name" />
		<br />
		<br/>
		
		<label>Lesson Text:</label>
		<form:input path="lesson_text" />
		<br />
		<br/>
		
		<label>Lesson Link:</label>
		<form:input path="link" />
		<br />
		<br/>
		
		<label>Course Name:</label>
		<form:input path="course.course_name" readonly="true"  disabled="true"/>
		<br/>
		<br/>
		<input type="submit" value="Add Lesson">

	</form:form>
	</div>

</body>
</html>