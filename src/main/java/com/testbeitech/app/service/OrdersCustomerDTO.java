package com.testbeitech.app.service;

import java.util.Date;

public interface OrdersCustomerDTO {
	
	Integer getOrder_id();

	Integer getCustomer_id();

	Date getCreation_date();

	Double getTotal();

	String getDelivery_address();

	Integer getQuantity();

	String getName();

}
