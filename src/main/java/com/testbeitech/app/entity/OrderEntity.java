package com.testbeitech.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`order`", catalog = "test")

public class OrderEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", columnDefinition="int(10) unsigned")
	private Integer order_id;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
	
	@Column(name = "creation_date", columnDefinition="date")
	private Date creation_date;
	
	@Column(name = "delivery_address", columnDefinition="varchar(191)")
	private String delivery_address;
	
	@Column(name = "total", columnDefinition="double(15,2)")
	private Double total;
	
	//Constructs
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(CustomerEntity customer, Date creation_date, String delivery_address, Double total) {
		super();
		this.customer = customer;
		this.creation_date = creation_date;
		this.delivery_address = delivery_address;
		this.total = total;
	}
	
	//Getter and Setter

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
