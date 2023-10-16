package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
		//get() , load()
    	
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        // get() -Student 103
        Student student =(Student)session.load(Student.class, 103);
        System.out.println(student);
        
        Address address = (Address)session.get(Address.class, 3);
        System.out.println(address.getStreet());
        
        
        
        session.close();
        factory.close();
	}
}
