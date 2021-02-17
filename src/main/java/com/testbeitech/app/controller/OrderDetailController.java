package com.testbeitech.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.testbeitech.app.dto.RequestDTO;
import com.testbeitech.app.entity.CustomerEntity;
import com.testbeitech.app.entity.OrderEntity;
import com.testbeitech.app.entity.ProductEntity;
import com.testbeitech.app.repository.ICustomerRepository;
import com.testbeitech.app.repository.IOrderDetailRepository;
import com.testbeitech.app.repository.IOrderRepository;
import com.testbeitech.app.repository.IProductRepository;
import com.testbeitech.app.util.Util;

@RestController
@RequestMapping("/api/orders-detail")
public class OrderDetailController {
	
	@Autowired
	private IOrderDetailRepository orderDetailRepository;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IProductRepository productRepository;
	
	//Create Order Detail
	@PostMapping("/add")
	public ResponseEntity<String> saveOrderDetailByCustomer(@Valid @RequestBody RequestDTO request) throws JsonProcessingException, java.text.ParseException
	{
		//get customer data
		Optional<CustomerEntity> customerRequest = customerRepository.findById(request.getCustomer_id());
		if(customerRequest.isEmpty()) {return new ResponseEntity<>("Customer doesn't exist.", HttpStatus.BAD_REQUEST);}
		
		//get the products that are available to the customer
		List<Integer> availableProduct = orderDetailRepository.findProductAvailable(request.getCustomer_id());
		if(availableProduct.isEmpty()) {return new ResponseEntity<>("The customer does not have products available.", HttpStatus.BAD_REQUEST);}
		
		//Create customer	
		CustomerEntity customerNew = new CustomerEntity(customerRequest.get().getCustomer_id(), customerRequest.get().getName(), customerRequest.get().getEmail());
		
		//Cross the available products of the customer with the products of the new order
		List<Map<String, Integer>> productsAvailableForOrder = Util.validationProductAvailable(availableProduct, request);
		if(productsAvailableForOrder.isEmpty()) {return new ResponseEntity<>("Order products are not available to the customer.", HttpStatus.BAD_REQUEST);}
		
		List<Integer> listProductsIdOrderAvailable = Util.getProductsById(productsAvailableForOrder);
		List<ProductEntity> productsNew = productRepository.findAllById(listProductsIdOrderAvailable);
		boolean quantityEmpty = Util.getValidationQuantity(productsAvailableForOrder);
		if(!quantityEmpty) {return new ResponseEntity<>("The quantity of the products cannot be less than zero.", HttpStatus.BAD_REQUEST);}
		
		Double totalQuantity = Util.getTotalQuantity(productsNew, productsAvailableForOrder);
		
		//Create order
		OrderEntity orderNew = new OrderEntity(customerNew, new Date(), request.getDelivery_address(), totalQuantity);
		
		ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(orderNew));
		
		for(int i=0; i < productsNew.size(); i++)
		{
			ProductEntity productNew = new ProductEntity(productsNew.get(i).getProduct_id(), productsNew.get(i).getName(), productsNew.get(i).getProduct_description(), productsNew.get(i).getPrice());
			
			orderDetailRepository.saveOrderDetail(orderNew.getOrder_id(), productNew.getProduct_id(), productNew.getProduct_description(), productNew.getPrice(), Integer.parseInt(productsAvailableForOrder.get(i).get("quantity").toString()));

		}
		
		return new ResponseEntity<>("Order (id:" + orderNew.getOrder_id() + ") created successfully", HttpStatus.OK);
	}
	
}



