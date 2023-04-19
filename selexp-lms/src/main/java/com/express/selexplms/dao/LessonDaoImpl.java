package com.express.selexplms.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.express.selexplms.entity.Lesson;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Lesson lesson) {

		Session currentSession = sessionFactory.getCurrentSession();

		Serializable id = currentSession.save(lesson);

		return (Integer) id;
	}

}
