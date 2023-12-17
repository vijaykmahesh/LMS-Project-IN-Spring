package com.express.selexplms.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.express.selexplms.entity.MyAppUser;
import com.express.selexplms.entity.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomUserDAOImpl implements CustomUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MyAppUser user) {

		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		Student student = new Student(user.getUsername(), user.getPassword(), user.getEmail());

		Serializable savedObject = (Serializable) session.save(student);

		System.out.println("saved CustomUserDAOImpl" + student);

		System.out.println("CustomUserDAOImpl save() ");

	}

	@Override
	public UserDetails loadUserByUsername(String username) {

		Session session = sessionFactory.getCurrentSession();

		System.out.println("loadUserByUsername username ");

		
		Query query = session.createQuery("from Student where username= :username");
		query.setParameter("username", username);

		Student student = (Student) query.uniqueResult();

		System.out.println("Email=" + student.getEmail() + ", username=" + student.getUsername() + " password"
				+ student.getPassword());
		
		
		//List<RolesDTO> rolesDTOLIst = jdbcTemplate.query(roleSql, new BeanPropertyRowMapper<>(RolesDTO.class) ,username);
		
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		
	    roles.add(new SimpleGrantedAuthority("user"));
		

		UserDetails userDetails = new MyAppUser(student.getUsername(), student.getPassword(), roles, student.getEmail());

		return userDetails;
	}

}
