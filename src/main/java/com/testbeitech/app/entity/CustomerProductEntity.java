package com.testbeitech.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_product")
public class CustomerProductEntity implements Serializable{
	
	@Id
	@ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
	
	@Id
	@ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;

}
