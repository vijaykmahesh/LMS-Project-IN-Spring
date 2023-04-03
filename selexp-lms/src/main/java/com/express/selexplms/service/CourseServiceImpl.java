package com.express.selexplms.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.express.selexplms.dao.CourseDAO;
import com.express.selexplms.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDao;

	@Transactional
	@Override
	public Course findCourseById(int courseId) {

		Course course = courseDao.findCourseById(courseId);

		Hibernate.initialize(course.getLessons());
		// inside course entity instead of using fetchType Eager we can use this line
		return course;
	}

}
