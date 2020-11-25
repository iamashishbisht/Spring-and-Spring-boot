package MyPackage.CustomerDaoClass;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import MyPackage.MyEntityClass.Customer;

@Component
@Transactional
public interface CustomerDao {
	
	public List<Customer> getCustomerList();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

}
