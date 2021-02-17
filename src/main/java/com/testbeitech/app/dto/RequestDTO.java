package com.testbeitech.app.dto;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestDTO{
	
	@Valid
	@NotNull
	
	private int customer_id;
	
	@Valid
	@NotNull
	@NotEmpty
	List<Map<String,Integer>> products;
	
	@Valid
	@NotNull
	@NotEmpty()
	private String delivery_address;
	

	public List<Map<String, Integer>> getProducts() {
		return products;
	}


	public void setProducts(List<Map<String, Integer>> products) {
		this.products = products;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getDelivery_address() {
		return delivery_address;
	}


	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	
	
}
