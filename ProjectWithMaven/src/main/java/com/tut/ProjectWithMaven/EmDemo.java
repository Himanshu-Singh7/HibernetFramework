package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student1 = new Student();
        student1.setId(1423);
        student1.setName("Bachau");
        student1.setCity("Varansi");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Java Development");
        certificate1.setCourse("6 Months");
       
        student1.setCerti(certificate1);
        
        Student student2 = new Student();
        student2.setId(1493);
        student2.setName("Ankit Tiwari");
        student2.setCity("Patana");
        
        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Android Development");
        certificate2.setCourse("7 Months");
       
        student1.setCerti(certificate2);
        
        Session se = factory.openSession();
        Transaction tx = se.beginTransaction();
        // Object save
        
        se.save(student1);
        se.save(student2);
        
        
        tx.commit();
        se.close();
        factory.close();
	}
}
