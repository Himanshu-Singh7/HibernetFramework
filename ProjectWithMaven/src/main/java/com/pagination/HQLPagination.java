package com.pagination;
import org.hibernate.query.*;
import com.tut.ProjectWithMaven.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {
	public static void main(String[] args) {
      Configuration cnf = new Configuration();
      cnf.configure("hibernate.cfg.xml");
      SessionFactory factory = cnf.buildSessionFactory();
      Session s = factory.openSession();
      Query<Student> q1 = s.createQuery("from Student",Student.class);
      //implemanting pagination
      
      q1.setFirstResult(10);
      
      q1.setMaxResults(5);
      
      List<Student> list =  q1.list();
      for(Student s1 : list) {
    	  System.out.println(s1.getId() +":"+s1.getName()+":"+s1.getCity());
      }
      
      
      
      
      s.close();
      factory.close();
	}
}
