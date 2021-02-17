package com.testbeitech.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbeitech.app.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public List<OrdersCustomerDTO> findAllOrderByIdCustomerByCreationDate(Integer customer_id, Date start_date, Date end_date) {
		
		List<OrdersCustomerDTO> listOrder = orderRepository.findAllOrderByIdCustomerByCreationDate(customer_id, start_date, end_date);
		
		return listOrder;
	}
	

}
