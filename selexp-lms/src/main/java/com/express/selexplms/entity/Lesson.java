package com.express.selexplms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Lesson")
@Data // we don't need to add getter and setter
@NoArgsConstructor
@ToString
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

}
