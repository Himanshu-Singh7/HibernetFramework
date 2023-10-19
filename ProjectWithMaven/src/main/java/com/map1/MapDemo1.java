package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Instructor ins = new Instructor();
		ins.setId(124);
		ins.setFirstName("Himanshu");
		ins.setLastName("Singh");
	    ins.setEmail("himanshusingh0608@gmail.com");
		
		Course course1 = new Course();
		course1.setCourseId(532);
		course1.setTitle("Java Course");
		course1.setInstructor(ins);
		
		Course course2 = new Course();
		course2.setCourseId(534);
		course2.setTitle("Python Course");
		course2.setInstructor(ins);
		
		Course course3 = new Course();
		course3.setCourseId(535);
		course3.setTitle("C++ Course");
		course3.setInstructor(ins);
		
		List<Course> list = new ArrayList<Course>();
		list.add(course1);
		list.add(course2);
		list.add(course3);
		ins.setCourse(list);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(ins);
		s.save(course1);
		s.save(course2);
		s.save(course3);
	
		
		// featching.....
		Instructor instructor = (Instructor)s.get(Instructor.class, 124);
		System.out.println(instructor.getId());
		System.out.println(instructor.getFirstName());
		System.out.println(instructor.getLastName());
		System.out.println(instructor.getEmail());
		
		//LAZY Loading
		System.out.println(instructor.getCourse().size());
		
		System.out.println(instructor.getFirstName());
		
		for(Course c :instructor.getCourse() ) {
			System.out.println(c.getTitle());
		}
		
		tx.commit();
		s.close();
		factory.close();
		
	}
}
