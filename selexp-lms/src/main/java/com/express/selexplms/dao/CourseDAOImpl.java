package com.express.selexplms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.express.selexplms.entity.Course;

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

}
