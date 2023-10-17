package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//Creating question
		
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java? ");
		
		// Creating Answer object
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is a programming language");
		answer1.setQuestion(q1);
	    q1.setAnswer(answer1);
	    
	    Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection faramework ? ");
		
		// Creating Answer object
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("API to works with object in java");
		answer2.setQuestion(q2);
	    q2.setAnswer(answer2);
	    
	    
	    Session s = factory.openSession();
	    Transaction tx = s.beginTransaction();
		
	    //save
	    s.save(q1);
	    s.save(q2);
	    s.save(answer1);
	    s.save(answer2);
	    
	    tx.commit();
	    
	    //fetching....
	    
	   Question newQ = (Question)s.get(Question.class, 1212);
	   System.out.println(newQ.getQuestion());
	   System.out.println(newQ.getAnswer().getAnswer());
	   
		s.close();
		factory.close();
	}
}
