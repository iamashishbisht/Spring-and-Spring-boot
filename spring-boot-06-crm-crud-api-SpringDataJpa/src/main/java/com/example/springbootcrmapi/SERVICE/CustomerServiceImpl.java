package com.example.springbootcrmapi.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcrmapi.ENTITY.Customer;
import com.example.springbootcrmapi.JpaReplacingDao.CustomerJpa;



@Component
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerJpa customerjpa;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerjpa.findAll();  // findAll predefined
	} 
	
	@Transactional
	public void addCustomer(Customer theCustomer) {
		
		customerjpa.save(theCustomer);		
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Optional <Customer> result =customerjpa.findById(id);
		
		Customer theCustomer = null;
		if (result.isPresent()){
			theCustomer = result.get();
			
		}
		return theCustomer;
	}
    
	@Transactional
	@Override
	public void deleteCustomer(int id) {
		customerjpa.deleteById(id);
		
	}

}
