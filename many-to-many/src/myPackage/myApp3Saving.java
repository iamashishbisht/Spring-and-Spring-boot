package myPackage;

//package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class myApp3Saving {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			/*
			Course course = new Course("Mahabharat12");
			
			
			course.addReview(new Review("3 star"));
			course.addReview(new Review("5 star"));
			
			session.save(course);
			*/
			Course course = new Course();
			course = session.get(Course.class, 10);
			
			Student student1 = new Student("Ashish", "Bisht", "bisht@yahoo.in");
			Student student2 = new Student("Ashi2", "Bisht", "hello@yahoo.in");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			// commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





