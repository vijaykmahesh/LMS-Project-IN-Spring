package com.express.selexplms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.express.selexplms.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Instructor> findAllInstructor() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Instructor> query = session.createQuery("from Instructor", Instructor.class);
		List<Instructor> listInstructor = query.list();

		session.getTransaction().commit();
//		session.close();

		return listInstructor;
	}

}
