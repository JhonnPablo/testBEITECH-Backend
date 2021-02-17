package com.testbeitech.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbeitech.app.repository.ICustomerRepository;
import com.testbeitech.app.service.CustomerDTO;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@GetMapping(value= "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDTO>> getOrderById()
	{
		List<CustomerDTO> listOrder = customerRepository.findAllCustomer();
		
		if(listOrder.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else
		{
			return ResponseEntity.ok(listOrder);
		}
	}

}
