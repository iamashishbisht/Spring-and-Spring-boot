package myPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class myAppGet {

	public static void main(String[] args) {


		     SessionFactory factory =    new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .buildSessionFactory();
		     
		    Session session =    factory.getCurrentSession(); 
		    
		    session.beginTransaction();
		    
		    InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
		    
		    System.out.println("Instructor Detail : " + instructorDetail);
		    
		    System.out.println("Instructor : " + instructorDetail.getInstructor());
		        
		    session.getTransaction().commit();
		    
		    session.close();
		    
		    
	}

}
