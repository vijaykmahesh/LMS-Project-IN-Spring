package com.express.selexplms.dao;

import java.util.List;

import com.express.selexplms.entity.Instructor;

public interface InstructorDAO {
	
	public List<Instructor> findAllInstructor();

	public void save(Instructor instructor);

	public Instructor searchInstructor(int id);

	public void deleteInstructor(int id);

}
