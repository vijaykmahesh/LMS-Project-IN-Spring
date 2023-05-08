package com.express.selexplms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Course")
@Data // we don't need to add getter and setter
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;

	private String course_name;

	private String course_duration;

	@ManyToOne
	@JoinColumn(name = "fk_instructor_id")
	private Instructor instructor;

	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
	private List<Lesson> lessons;

	
}
