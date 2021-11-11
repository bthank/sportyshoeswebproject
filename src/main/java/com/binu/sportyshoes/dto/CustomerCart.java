package com.binu.sportyshoes.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerCart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String customerUsername;
	
	@OneToMany
	private List<OrderItem> orderItems;

	public CustomerCart() {
		
	}

	public CustomerCart(Integer id, String customerUsername, List<OrderItem> orderItems) {
		 
		this.id = id;
		this.customerUsername = customerUsername;
		this.orderItems = orderItems;
	}

	public CustomerCart(String customerUsername, List<OrderItem> orderItems) {
		super();
		this.customerUsername = customerUsername;
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerUsername == null) ? 0 : customerUsername.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerCart other = (CustomerCart) obj;
		if (customerUsername == null) {
			if (other.customerUsername != null)
				return false;
		} else if (!customerUsername.equals(other.customerUsername))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerCart [id=" + id + ", customerUsername=" + customerUsername + ", orderItems=" + orderItems + "]";
	}


	
	
	
}
