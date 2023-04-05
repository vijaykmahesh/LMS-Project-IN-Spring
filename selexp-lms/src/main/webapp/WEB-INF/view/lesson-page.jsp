<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.express.selexplms.entity.Lesson"%>
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
	
	<%
		Lesson lesson = (Lesson)request.getAttribute("lesson");
		int nextLessonId = lesson.getLesson_id()+1;
		pageContext.setAttribute("nextLessonId", nextLessonId);
		
		int previousLessonId = lesson.getLesson_id()-1;
		pageContext.setAttribute("previousLessonId", previousLessonId);
	%>
<div class="container">
	<h1>${lesson.lesson_name}</h1>
	<hr>
	
	<h2>${lesson.lesson_text}</h2>

	<div align="center">
	
	<h2>${lesson.link}</h2>
	
	</div>
	
	<c:if test="${nextLessonId <= lessonCount.lastLessonNumber}">
	<div align="right">
	<a href="/selexp-lms/openLesson?id=${nextLessonId}">Next Video</a>
	</div>	
	
	</c:if>
	
	<c:if test="${previousLessonId >= lessonCount.firstLessonNumber}">
	<div align="left">
	<a href="/selexp-lms/openLesson?id=${previousLessonId}">Previous Video</a>
	</div>	
	</c:if>
	
	
</div>

</body>
</html>