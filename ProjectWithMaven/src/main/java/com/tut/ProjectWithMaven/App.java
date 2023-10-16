package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        SessionFactory factory = cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
       // Student Object 
        Student st = new Student();
        st.setId(103);
        st.setName("Rahul");
        st.setCity("Varansi");
        
       System.out.println(st);
       Session session = factory.getCurrentSession();
       Transaction tx =session.beginTransaction();
       session.save(st);
       tx.commit();
       session.close();
        
    }
}
