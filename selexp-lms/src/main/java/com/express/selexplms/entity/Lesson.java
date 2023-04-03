package com.express.selexplms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lesson")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lesson_id;
	
	private String lesson_text;
	
	private String lesson_name;
	
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "fk_course_id")
	private Course course;

	public int getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}

	public String getLesson_text() {
		return lesson_text;
	}

	public void setLesson_text(String lesson_text) {
		this.lesson_text = lesson_text;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}
	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
