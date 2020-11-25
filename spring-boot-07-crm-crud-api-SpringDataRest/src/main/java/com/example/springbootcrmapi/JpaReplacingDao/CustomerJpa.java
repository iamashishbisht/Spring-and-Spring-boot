package com.example.springbootcrmapi.JpaReplacingDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootcrmapi.ENTITY.Customer;


//now it will provide predefined function
// which were earlier written by us in DAO
// these predefined function are findById, findAll, save, deleteById



//No need for controllers, service layer and dao provided by spring-data-rest by itself the endpoints as well
public interface CustomerJpa extends JpaRepository<Customer, Integer> {

}
