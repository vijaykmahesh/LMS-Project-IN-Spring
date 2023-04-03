<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="menu.jsp"%>

	<div class="container">
		<h1>Available Instructors</h1>

		<form:form action="process-search" method="GET"
			modelAttribute="searchDTO">

			<label>Search Instructor</label>
			<form:input path="id" />
			<input type="submit" value="submit">

		</form:form>

		<div align="right">

			<a href="/selexp-lms/instructor-info">Refresh List</a>

		</div>

		<br />

		<table class="table">
			<thead class="table-info">
				<tr>
					<th>InstructorId</th>
					<th>InstructorName</th>
					<th>InstructorTrainingExp</th>
					<th>InstructorEmail</th>
					<th>Courses</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="instructor" items="${instructorList}">

					<tr>
						<td>${instructor.instructor_id}</td>
						<td>${instructor.instructor_name}</td>
						<td>${instructor.instructor_training_exp}</td>
						<td>${instructor.instructor_email}</td>
						<td>
							<table class="table">
								<thead class="table-info">
									<tr>
										<td>CourseName</td>
										<td>Duration</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="course" items="${instructor.courses}">

										<tr>

											<td>${course.course_name}</td>
											<td>${course.course_duration}</td>
											<td><a href="/selexp-lms/viewCourse?courseId=${course.course_id}">View</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
						<td><a class="btn btn-danger"
							href="/selexp-lms/deleteInstructor?id=${instructor.instructor_id}">delete</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>

	</div>



</body>
</html>