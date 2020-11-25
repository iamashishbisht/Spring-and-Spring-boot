package MyPackage.CustomerServicesClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MyPackage.CustomerDaoClass.CustomerDao;
import MyPackage.MyEntityClass.Customer;

@Component
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerDao.getCustomerList();
	}
	
	@Transactional
	public void addCustomer(Customer theCustomer) {
		
		customerDao.addCustomer(theCustomer);		
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}
    
	@Transactional
	@Override
	public void deleteCustomer(int id) {
		 customerDao.deleteCustomer(id);
		
	}

}
