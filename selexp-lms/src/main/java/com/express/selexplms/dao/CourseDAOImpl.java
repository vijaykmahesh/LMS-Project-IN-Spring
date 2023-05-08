package com.express.selexplms.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.express.selexplms.entity.Course;
import com.express.selexplms.entity.Lesson;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Course findCourseById(int courseId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Course course = currentSession.get(Course.class, courseId);

		return course;
	}

	@Override
	public Lesson findLessonById(int lessonId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Lesson lesson = currentSession.get(Lesson.class, lessonId);

		return lesson;
	}

	@Override
	public int save(Course course) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Serializable id = (Serializable) currentSession.save(course);
		
		return (Integer)id;
		
	}

}
