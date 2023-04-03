package com.express.selexplms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructor_id;

	private String instructor_name;

	private int instructor_training_exp;

	private String instructor_email;
	
	@OneToMany(mappedBy = "instructor",fetch = FetchType.EAGER)
	private List<Course> courses;


	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public int getInstructor_training_exp() {
		return instructor_training_exp;
	}

	public void setInstructor_training_exp(int instructor_training_exp) {
		this.instructor_training_exp = instructor_training_exp;
	}

	public String getInstructor_email() {
		return instructor_email;
	}

	public void setInstructor_email(String instructor_email) {
		this.instructor_email = instructor_email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
