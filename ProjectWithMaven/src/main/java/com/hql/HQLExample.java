package com.hql;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	s.close();
	factory.close();
  }
}
