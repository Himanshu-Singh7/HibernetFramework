package com.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id")
	private int courseId;
    
    @Column(name = "title")
	private String title;
    
    @ManyToOne
	private Instructor instructor;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int courseId, String title, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.instructor = instructor;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
