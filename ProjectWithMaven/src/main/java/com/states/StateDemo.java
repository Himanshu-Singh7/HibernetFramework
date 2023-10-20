package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Certificate;
import com.tut.ProjectWithMaven.Student;

public class StateDemo {
	public static void main(String[] args) {
		// Pratical of hibernet of object state
		// Transient State
		// Persistance state
		// Detached State
		// Remove state
		System.out.println("Example :");
		
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		// Creating student object
		
		Student student = new Student();
		student.setId(453);
		student.setName("New Name");
		student.setCity("varansi");
		student.setCerti(new Certificate("java hibernate course" , "2 Months"));
		// Student : Transient State
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		// Student : Persistance state -session , Dtabase
		student.setName("Jhon");
		
		tx.commit();
		s.close();
		//student :Detached State
		
		student.setName("Sachin");
		System.out.println(student);
		factory.close();

	}

}
