package com.cascad;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map1.Course;
import com.map1.Instructor;

public class CascadeExample {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		Session s = factory.openSession();
		Instructor in1 = new Instructor();
		in1.setId(5697);
		in1.setFirstName("Deji");
		in1.setLastName("Singh");
		in1.setEmail("dejisingsingh@gmail.com");
		Course co1 = new Course(1243,"Cyber security");
		Course co2 = new Course(1245,"Network security");
		Course co3 = new Course(1247,"Cloud computing");
	    List<Course> list = new ArrayList<>();
		list.add(co1);
		list.add(co2);
		list.add(co3);
		in1.setCourse(list);
		Transaction tx = s.beginTransaction();
		s.save(in1);
		
		
		tx.commit();
		s.close();
		factory.close();
	}

}
