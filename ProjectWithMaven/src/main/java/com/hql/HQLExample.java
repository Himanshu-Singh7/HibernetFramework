package com.hql;

import java.util.Arrays;
import java.util.List;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class HQLExample {
   public static void main(String[] args) {
	Configuration cnf = new Configuration();
	cnf.configure("hibernate.cfg.xml");
	SessionFactory factory = cnf.buildSessionFactory();
	Session s = factory.openSession();
	//HQL
	//Syntax
	String query = "from Student as s where s.city =: x and s.name =: n";
	Query q =s.createQuery(query);
	q.setParameter("x", "Varansi");
	q.setParameter("n", "Rahul Singh");
	 
	List<Student> list = q.list();
	 for(Student student : list) {
		 System.out.println(student.getName() + ":"+student.getCerti().getCourse());
	 }
	 
	 System.out.println("______________________________________________________________");
	 Transaction tx = s.beginTransaction();
//___________________________Delete____________________________________________________
//	Query query1 = s.createQuery("delete from  Student s where s.city =: c");
//	query1.setParameter("c","Patana");
//	int d = query1.executeUpdate();
//	System.out.println("Deleted : ");
//	System.out.println(d);
// ___________________________Update____________________________________________________
	 
//	Query query2 = s.createQuery("update Student set city =: c where name =: n");
//	query2.setParameter("c", "Patana");
//	query2.setParameter("n","Bachau");
//	int u = query2.executeUpdate();
//	System.out.println(u + " : object updated");

//_______________________________Join___________________________________________________
	 
    Query query3 = 
    s.createQuery("select i.id,i.firstName,i.lastName,i.email,t.title from Instructor as i INNER JOIN i.course as t");
    
   List<Object[]> list3 = query3.getResultList();
   for(Object[] arr : list3) {
	   System.out.println(Arrays.toString(arr));
   }
     
	 
	tx.commit();
	s.close();
	factory.close();
  }
}
