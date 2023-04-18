<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>${course.course_name}</h1>
	<hr>
	<h3>Lessons</h3>
	
	<c:set var="pagedLessonList" value="${lessonList}" scope="session"></c:set>
	
	<c:forEach var="lesson" items="${pagedLessonList.pageList}">
	
	<a href="/selexp-lms/openLesson?id=${lesson.lesson_id}">${lesson.lesson_name}</a>
	
	<br/> 
	
	</c:forEach>
	
	
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

</body>
</html>