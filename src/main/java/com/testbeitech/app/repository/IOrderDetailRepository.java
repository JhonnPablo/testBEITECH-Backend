package com.testbeitech.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testbeitech.app.entity.OrderDetailEntity;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity,Integer>{
	
	Optional<OrderDetailEntity> findById(Integer order_detail_id);

	@Query(value="SELECT cp.product_id FROM customer c JOIN customer_product cp ON (c.customer_id = cp.customer_id) where c.customer_id = :customer_id", nativeQuery = true)
	List<Integer> findProductAvailable(Integer customer_id);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO order_detail (order_id, product_id, product_description, price, quantity) VALUES(:order_id,:product_id, :product_description, :price, :quantity)", nativeQuery = true)
	void saveOrderDetail(Integer order_id, Integer product_id, String product_description, Double price, Integer quantity);
	
}
