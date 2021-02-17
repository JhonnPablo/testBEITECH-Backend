package com.testbeitech.app.service;

import java.util.Date;
import java.util.List;


public interface IOrderService {
	
	List<OrdersCustomerDTO> findAllOrderByIdCustomerByCreationDate(Integer customer_id, Date start_date, Date end_date);
	
}
