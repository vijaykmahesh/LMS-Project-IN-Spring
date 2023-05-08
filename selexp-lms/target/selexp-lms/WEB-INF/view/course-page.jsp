<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
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
	<h1>${course.course_name}</h1>
	<br/>
	<a href="/selexp-lms/addLesson?courseId=${courseId}" class="btn btn-primary">Add Lesson</a>
	<hr>
	<c:set var="pagedLessonList" value="${lessonList}" scope="session"></c:set>
	
	<table class="table">
			<thead class="table-info">
				<tr>
					<th>Lesson Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lesson" items="${pagedLessonList.pageList}">

					<tr>
						<td><a href="/selexp-lms/openLesson?id=${lesson.lesson_id}">${lesson.lesson_name}</a></td>
						<td><a href="/selexp-lms/addLesson?courseId=${courseId}&lessonId=${lesson.lesson_id}" class="btn btn-success">Edit</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	
	
	<%--Below condition means if it is in first page then block prev or else show prev--%> 
	<c:choose>
	
	<c:when test="${pagedLessonList.firstPage}">prev</c:when>
	
	<c:otherwise>
	<a href="/selexp-lms/viewCourse?courseId=${courseId}&pageNum=prev">prev</a>
	</c:otherwise>
	
	</c:choose>
	<c:forEach begin="0" end="${pagedLessonList.pageCount-1}" varStatus="loop">
	
	<a href="/selexp-lms/viewCourse?courseId=${courseId}&pageNum=${loop.index}">${loop.index}</a>
	
	</c:forEach>
	
	
	<%--Below condition means if it is in last page then block next or else show next --%> 
	
	
	<c:choose>
	
	<c:when test="${pagedLessonList.lastPage}">next</c:when>
	
	<c:otherwise>
	<a href="/selexp-lms/viewCourse?courseId=${courseId}&pageNum=next">next</a>
	</c:otherwise>
	
	</c:choose>

</div>
</body>
</html>