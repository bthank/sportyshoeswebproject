package com.binu.sportyshoes.service;

import java.util.List;

import com.binu.sportyshoes.dto.ShoeOrder;
import com.binu.sportyshoes.dto.User;

public interface ShoeOrderService {

	ShoeOrder getShoeOrderById(Integer id);
	List<ShoeOrder> getAllShoeOrders();
	ShoeOrder addShoeOrder(ShoeOrder shoeOrder);
	
	 
	List<ShoeOrder> findByOrderType(String orderType);
	 
}
