package com.testbeitech.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbeitech.app.repository.IOrderRepository;
import com.testbeitech.app.service.OrdersCustomerDTO;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@GetMapping(value= "/customer/{id}/start-date/{sd}/end-date/{ed}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersCustomerDTO>> getOrderById(@PathVariable("id") Integer customer_id, @PathVariable("sd") Date start_date, @PathVariable("ed") Date end_date)
	{
		List<OrdersCustomerDTO> listOrder = orderRepository.findAllOrderByIdCustomerByCreationDate(customer_id, start_date, end_date);
		
		if(listOrder.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else
		{
			return ResponseEntity.ok(listOrder);
		}
	}
	
}
