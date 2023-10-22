package com.criteria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.ProjectWithMaven.Student;

public class CriteriaExample {
	public static void main(String[] args) {

		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Student.class);
		
		//Giving some restiriction Restriction 
//		c.add(Restrictions.eq("certi.course","Java Development"));
		// Greater than
//		c.add(Restrictions.gt("id", 14));
		//Like 
		c.add(Restrictions.like("certi.course", "Data%"));
		
		List<Student> student = c.list();
        for (Student st : student) {
			System.out.println(st);
		}
    	session.close();
		factory.close();
	}
}
