package myPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class myApp3Saving {

	public static void main(String[] args) {


		     SessionFactory factory =    new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .buildSessionFactory();
		     
		    Session session =    factory.getCurrentSession(); 
		     
		    
		    Instructor instructor = new Instructor("Ashish", "Bisht", "ashish@gmail.com/hotmail");
		    
		    InstructorDetail instructorDetail = new InstructorDetail("ashi@youtube.com","cricket/hockey");
		    
		    //association
		    instructor.setInstructorDetail(instructorDetail);
		    //instructorDetail.setInstructor(instructor);
		    
		    session.beginTransaction();
		    
		    //session.save(instructorDetail);
		    session.save(instructor);
		    
		    session.getTransaction().commit();
		    
		    session.close();
		    
		    
	}

}
