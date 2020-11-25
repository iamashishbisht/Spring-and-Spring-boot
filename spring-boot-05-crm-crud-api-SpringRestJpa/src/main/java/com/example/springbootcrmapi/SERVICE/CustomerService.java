package com.example.springbootcrmapi.SERVICE;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootcrmapi.ENTITY.Customer;



@Service
public interface CustomerService {
	
	public List<Customer> getCustomerList();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

}
