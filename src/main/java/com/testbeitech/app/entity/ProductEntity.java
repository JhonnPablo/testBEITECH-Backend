package com.testbeitech.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", columnDefinition="int(10) unsigned")
	private Integer product_id;
	
	@Column(name = "name", columnDefinition="varchar(191)")
	private String name;
	
	@Column(name = "product_description", columnDefinition="varchar(191)")
	private String product_description;
	
	@Column(name = "price", columnDefinition="double(10,2)")
	private Double price;
	
	//Constructs
	
	public ProductEntity() {
		super();
	}

	public ProductEntity(Integer product_id, String name, String product_description, Double price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.product_description = product_description;
		this.price = price;
	}

	//Getter and Setter
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
