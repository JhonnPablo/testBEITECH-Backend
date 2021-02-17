package com.testbeitech.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testbeitech.app.entity.CustomerEntity;
import com.testbeitech.app.service.CustomerDTO;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity,Integer>{
	
	@Query(value="SELECT customer_id, name FROM customer", nativeQuery = true)
	List<CustomerDTO> findAllCustomer();
	
}
