package com.map2;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class MappingDemo {
	public static void main(String[] args) {
     Configuration cnf = new Configuration();
     cnf.configure("hibernate.cfg.xml");
     SessionFactory factory = cnf.buildSessionFactory();
     // Emp Object;
     Employees employees1 = new Employees();
     Employees employees2 = new Employees();
     
     employees1.setEmployeeId(12);
     employees1.setEmloyeeName("Ram");
     
     employees2.setEmployeeId(13);
     employees2.setEmloyeeName("Shyam");
     
     // Project object
     
     Project project1 = new Project();
     Project project2 = new Project();
     project1.setProjectId(2);
     project1.setProjectName("Libraray Management project");
     project2.setProjectId(3);
     project2.setProjectName("ChatBot");
     
     List<Employees> list1 = new ArrayList<Employees>();
     List<Project> list2 = new ArrayList<Project>();
     list1.add(employees1);
     list1.add(employees2);
     
     list2.add(project1);
     list2.add(project2);
     //
     employees1.setProject(list2);
     project1.setEmployees(list1);
     
     Session s = factory.openSession();
     Transaction tx = s.beginTransaction();
     s.save(employees1);
     s.save(employees2);
     s.save(project1);
     s.save(project2);
     
     tx.commit();
     s.close();
     factory.close();
	}
}
