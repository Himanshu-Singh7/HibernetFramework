package com.sqlQueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
     public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		Session s = factory.openSession();
		// Executing Native SQL Queries for retrive the data
		String q = "Select * from Student";
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		for(Object [] student : list) {
			System.out.println(student[3]+":"+student[4]);
		}
		
		
		
		s.close();
		factory.close();
	}
}
