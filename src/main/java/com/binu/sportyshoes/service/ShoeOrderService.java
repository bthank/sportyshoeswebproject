package com.binu.sportyshoes.service;

import java.sql.Date;
import java.util.List;

import com.binu.sportyshoes.dto.ShoeOrder;

public interface ShoeOrderService {

	ShoeOrder getShoeOrderById(Integer id);
	List<ShoeOrder> getAllShoeOrders();
	ShoeOrder addShoeOrder(ShoeOrder shoeOrder);
	
	 
	List<ShoeOrder> findByOrderType(String orderType);
	List<ShoeOrder> findByDateOfOrder(Date orderDate); 
	List<ShoeOrder> findByDateOfOrderAndOrderType(Date orderDate, String orderType); 
}
