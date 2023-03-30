package com.express.selexplms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.express.selexplms.dao.InstructorDAO;
import com.express.selexplms.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	InstructorDAO instructorDAO;

	@Override
	public List<Instructor> findAllInstructor() {
		
		return instructorDAO.findAllInstructor();
	}

	@Transactional
	@Override
	public void save(Instructor instructor) {
		
		instructorDAO.save(instructor);

	}

	@Transactional
	@Override
	public Instructor searchInstructor(int id) {
		
		return instructorDAO.searchInstructor(id);
	}

	@Transactional
	@Override
	public void deleteInstructor(int id) {

		instructorDAO.deleteInstructor(id);
	}

}
