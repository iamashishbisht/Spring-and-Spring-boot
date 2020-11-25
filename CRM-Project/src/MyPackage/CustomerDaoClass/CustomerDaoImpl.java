package MyPackage.CustomerDaoClass;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import MyPackage.MyEntityClass.Customer;

@Component
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomerList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		List<Customer> customers = currentSession.createQuery("from Customer", 
				                   Customer.class).getResultList();
		
		return customers;
		
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomerById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
		
        Customer theCustomer = currentSession.get(Customer.class, theId);
        //Query query = currentSession.createQuery("from Customer");
        //Customer customer =  query.getResultList();
		//Customer customer = (Customer) currentSession.createQuery("from Customer c where c.id ="+ id,
			//	                                       Customer.class).getResultList();
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
		
        Customer theCustomer = currentSession.get(Customer.class, theId);
        currentSession.delete(theCustomer);
		
	}

}
