package com.testbeitech.app.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testbeitech.app.entity.OrderEntity;
import com.testbeitech.app.service.OrdersCustomerDTO;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity,Integer>{
	
	@Query(value="SELECT o.order_id as order_id, o.customer_id as customer_id, o.creation_date as creation_date, o.total as total, o.delivery_address as delivery_address, od.quantity as quantity, p.name as name FROM `order` o JOIN order_detail od ON(o.order_id = od.order_id) JOIN product p ON(od.product_id = p.product_id) where o.customer_id = :customer_id and o.creation_date BETWEEN :start_date and :end_date", nativeQuery = true)
	List<OrdersCustomerDTO> findAllOrderByIdCustomerByCreationDate(Integer customer_id, Date start_date, Date end_date);
		
	Optional<OrderEntity> findById(Integer order_id);
	
}
