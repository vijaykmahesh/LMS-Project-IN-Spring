package com.express.selexplms.service;

import com.express.selexplms.entity.Course;
import com.express.selexplms.entity.Lesson;

public interface CourseService {
	
	public Course findCourseById(int courseId);

	public Lesson findLessonById(int lessonId);

	public int save(Course course);

}
