package com.express.selexplms.dao;

import com.express.selexplms.entity.Course;
import com.express.selexplms.entity.Lesson;

public interface CourseDAO {

	Course findCourseById(int courseId);
	
	Lesson findLessonById(int lessonId);

}
