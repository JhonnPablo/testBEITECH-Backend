package com.testbeitech.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name="customer",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class CustomerEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", columnDefinition="int(10) unsigned")
	@NotNull
	private Integer customer_id;
	
	@Column(name = "name", columnDefinition="varchar(191)")
	private String name;
	
	@Column(name = "email", columnDefinition="varchar(191)")
	private String email;
	
	//Constructs
	
	public CustomerEntity(Integer customer_id, String name, String email) {
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
	}

	public CustomerEntity() {
		super();
	}
	
	//Getter and Setter
	
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
