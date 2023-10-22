package com.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class SecondLevelCache {
     public static void main(String[] args) {
		
    	  Configuration cnf = new Configuration();
    	  cnf.configure("hibernate.cfg.xml");
    	  SessionFactory factory = cnf.buildSessionFactory();
    	  Session s1 = factory.openSession();
    	 //First
    	  Student student1 = s1.get(Student.class, 10);
    	  System.out.println(student1);
    	  
    	  s1.close();
    	  Session s2 = factory.openSession();
    	  
     	 //First
    	  //Second
    	  Student student2 = s2.get(Student.class, 10);
    	  System.out.println(student2);
          s2.close();
    	  
    	  factory.close();
	}
}
