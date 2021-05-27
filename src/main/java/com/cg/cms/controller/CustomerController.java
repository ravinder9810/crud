package com.cg.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cms.entities.Customer;
import com.cg.cms.service.ICustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
		@Autowired			// Autowired : we use this for not creating Object for a class
		private ICustomerService service;		// here we not used new keyWord 
								// that creation of object will take care by AUROWIRED 
							// it will check the methodName in which child class it exist
		
		
		@GetMapping("/{name}")
		@ApiOperation("greetings API")
		public String greetings(@PathVariable String name) {
			return "<h1>Welcome back Spring "  + name + "</h1>";
			
		}
		
		@GetMapping("getById/{id}")
		@ApiOperation("get Customer by Id ")
		public Customer fetchById(@RequestBody String id) {
			return service.fetchById(Integer.valueOf(id));
		}
		
		@GetMapping("/getAll")
		@ApiOperation("fetch all ")
		public List<Customer> fetch(){
			return service.fetchAll();
		}
		
		@PostMapping("/save")
		public void save(@RequestBody Customer customer) {
			service.updateCustomer(customer);
		}
		
		@PutMapping("/update")
		public void update(@RequestBody Customer customer) {
			service.updateCustomer(customer);
		}
		
		@DeleteMapping("/delete/{id}")
		public void delets(@PathVariable String id) {
			service.delCustomer(Integer.valueOf(id));
		}
		
		
		
}
