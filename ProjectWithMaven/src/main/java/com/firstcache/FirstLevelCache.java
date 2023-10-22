package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class FirstLevelCache {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		Session session = factory.openSession();

		// By default enabled
		Student student = session.get(Student.class, 3);
		System.out.println(student);
		System.out.println("Working something");

		Student student1 = session.get(Student.class, 3);
		System.out.println(student1);
		System.out.println(session.contains(student1));
		
		

		session.close();
		factory.close();
	}
}
