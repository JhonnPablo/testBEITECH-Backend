package com.testbeitech.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testbeitech.app.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity,Integer>{

}
