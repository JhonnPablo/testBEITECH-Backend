package com.testbeitech.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbeitech.app.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public List<CustomerDTO> findAllCustomer() {
		
		List<CustomerDTO> listCustomer = customerRepository.findAllCustomer();
		
		return listCustomer;
	}

}
