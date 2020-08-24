package myPackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
		                         .configure("hibernate.cfg.xml")
		                         .addAnnotatedClass(Student.class)
		                         .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
			//begin transaction
		System.out.println("begin transaction");
			session.beginTransaction();
			try {
				
				int studentId = 1;
				
			System.out.println("creating object");
			//creating object
			
			//Student stud = new Student("Ashish", "Bisht" , "Bisht@gmail.com");
			Student stud1 = new Student("Ashish", "Bisht" , "Bishtg@gmail.com");
			Student stud2 = new Student("Ashish", "Bisht" , "Bishtg@yahoo.com");
			
			//saving object
			//session.save(stud);
			System.out.println("saving...");
			session.save(stud1);
			System.out.println("saving...");
			session.save(stud2);
			
			System.out.println("Reading....");
			//Retrieving Student or reading
			Student myStudent = session.get(Student.class, stud2.getId());
			System.out.println("myStudent : "+ myStudent + " Id : " + stud2.getId());
			
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
			// or List<Student> studentList = session.createQuery("from Student").getResultList();
			System.out.println("List : " +  studentList);
			
			//List<Student> customList = session.createQuery("from Student s where s.lastName= 'Bisht'").getResultList();
			List<Student> customList = session.createQuery("from Student s where s.email= 'ashishbisht@gmail.com'").getResultList();
			// or List<Student> studentList = session.createQuery("from Student").getResultList();
			System.out.println("List : " +  customList);
			
			
			//updating database value using get
			System.out.println("getting student with ID");
			Student myStudent2 = session.get(Student.class, 5);
			System.out.println("get Complete : " + myStudent2);
			myStudent2.setLastName("Ashish");
			System.out.println("get Complete after update : " + myStudent2);
			
			
			//updating database value using HQL
			System.out.println("Updating using HQL");
			session.createQuery("update Student set email='bisht@hotmail.com' where email = 'Bishtg@yahoo.com'").executeUpdate();
			
			/*
			//deletion
			System.out.println("deleting the data");
			Student deleteStudent = session.get(Student.class, 8);
			session.delete(deleteStudent);
			*/
			
			/*
			//deletion using HQL
			System.out.println("deletion using HQL");
			session.createQuery("delete from Student where email = 'bisht@hotmail.com'").executeUpdate();
			*/
			
			System.out.println("commit...");
			//commit transaction
			session.getTransaction().commit();
			}
			finally {
			System.out.println("close session");
			session.close();
			}

	}

}
