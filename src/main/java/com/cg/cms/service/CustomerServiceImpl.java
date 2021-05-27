package com.cg.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cms.entities.Customer;
import com.cg.cms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public void addCustomer(Customer customer) {
		repository.save(customer);
		
	}

	@Override
	public List<Customer> fetchAll() {
		
		return repository.findAll();
	}

	@Override
	public void delCustomer(int id) {
			repository.deleteById(id);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
			
		repository.save(customer);
	}

	@Override
	public Customer fetchById(int id) {
		Customer cust = null;
		Optional<Customer> optional = repository.findById(id);
		if(optional.isPresent())
			cust = optional.get();
		return cust;
	}
	
	
}
