package com.example.springbootcrmapi.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcrmapi.ENTITY.Customer;
import com.example.springbootcrmapi.SERVICE.CustomerService;


@RestController
@RequestMapping("/api")
public class MyRestController {
     
	@Autowired
	 CustomerService customerService;
	
	
	@GetMapping("/customer")
	public List<Customer> findAll(){
		
		List<Customer> customerList = new ArrayList<>();
		
		customerList = customerService.getCustomerList();
		
		return customerList;
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer findById(@PathVariable int customerId){
		
		Customer thecustomer = new Customer();
		
		thecustomer = customerService.getCustomerById(customerId);
		
		return thecustomer;
	}
	
	@PostMapping("/customer")
    public Customer add(@RequestBody Customer customer){
		
		customer.setId(0);
		
		customerService.addCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public String Delete(@PathVariable int customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted record with id : " + customerId;
	}
	
	
}
