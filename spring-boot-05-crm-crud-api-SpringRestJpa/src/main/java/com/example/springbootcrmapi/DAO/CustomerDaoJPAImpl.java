package com.example.springbootcrmapi.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springbootcrmapi.ENTITY.Customer;



@Component
@Repository
public class CustomerDaoJPAImpl implements CustomerDao {

	//@Autowired
	//private SessionFactory sessionFactory;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getCustomerList() {
		
		//Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<Customer> customers = currentSession.createQuery("from Customer", 
				                   Customer.class).getResultList();
		
		return customers;
		
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		//Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.merge(theCustomer);
		
	}

	@Override
	public Customer getCustomerById(int theId) {
        //Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);
		
        Customer theCustomer = currentSession.get(Customer.class, theId);
        //Query query = currentSession.createQuery("from Customer");
        //Customer customer =  query.getResultList();
		//Customer customer = (Customer) currentSession.createQuery("from Customer c where c.id ="+ id,
			//	                                       Customer.class).getResultList();
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
        //Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);
		
        Customer theCustomer = currentSession.get(Customer.class, theId);
        currentSession.remove(theCustomer);
		
	}

}
