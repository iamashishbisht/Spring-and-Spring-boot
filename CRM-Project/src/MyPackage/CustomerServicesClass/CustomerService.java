package MyPackage.CustomerServicesClass;

import java.util.List;

import org.springframework.stereotype.Service;

import MyPackage.MyEntityClass.Customer;

@Service
public interface CustomerService {
	
	public List<Customer> getCustomerList();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

}
