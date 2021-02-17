package com.testbeitech.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetailEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id", columnDefinition="int(10) unsigned")
	private Integer order_detail_id;
	
	@ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private OrderEntity order;
	
	@ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductEntity product;
	
	@Column(name = "product_description", columnDefinition="varchar(191)")
	private String product_description;
	
	@Column(name = "price", columnDefinition="double(10,2)")
	private Double price;
	
	@Column(name = "quantity", columnDefinition="int(10) unsigned default 1")
	private Integer quantity;
	
	//Constructs
	
	public OrderDetailEntity(Integer order_detail_id, OrderEntity order, ProductEntity product,
			String product_description, Double price, Integer quantity) {
		super();
		this.order_detail_id = order_detail_id;
		this.order = order;
		this.product = product;
		this.product_description = product_description;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderDetailEntity() {
		super();
	}

	public Integer getOrder_detail_id() {
		return order_detail_id;
	}

	//Getter and Setter

	public void setOrder_detail_id(Integer order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
