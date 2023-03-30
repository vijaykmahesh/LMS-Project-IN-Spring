package com.express.selexplms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void save(Instructor instructor) {
		
		// we don't need to explicitly open and close session
		Session session = sessionFactory.getCurrentSession(); 
		
		// If we use getCurrentSession() we have to create TransactionManager object and mark method with 
		// @Transactional
		
		Serializable savedObject = session.save(instructor);
		
		System.out.println("saved instructor" +savedObject);
		
		
		
	}

	@Override
	public Instructor searchInstructor(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Instructor instructor = currentSession.get(Instructor.class, id);
		
		return instructor;
	}

	@Override
	public void deleteInstructor(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Instructor instructor = currentSession.get(Instructor.class, id);
		
		currentSession.delete(instructor);
		
		
	}

}
