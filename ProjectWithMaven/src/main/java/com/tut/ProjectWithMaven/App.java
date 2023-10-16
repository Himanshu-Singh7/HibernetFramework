package com.tut.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )throws IOException{
        System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        SessionFactory factory = cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
       
        //creating object of student 
        Student st = new Student();
        st.setId(103);
        st.setName("Rahul");
        st.setCity("Varansi");
        
        //Creating object of Address
        Address address = new Address();
  
        address.setStreet("Street1");
        address.setCity("Banglore");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.5432);
        //Reading image
        
        FileInputStream file = new FileInputStream("src/main/java/image.png.jpeg");
        byte[] data = new byte[file.available()];
        file.read(data);
        address.setImage(data);
        
       System.out.println(st);
       Session session = factory.getCurrentSession();
       Transaction tx =session.beginTransaction();
       session.save(st);
       session.save(address);
       tx.commit();
       session.close();
       System.out.println("Done...");
        
    }
}
