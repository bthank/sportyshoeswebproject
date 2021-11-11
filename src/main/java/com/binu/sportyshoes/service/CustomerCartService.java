package com.binu.sportyshoes.service;

import java.util.List;

import com.binu.sportyshoes.dto.CustomerCart;
import com.binu.sportyshoes.dto.OrderItem;

public interface CustomerCartService {

	List<OrderItem> getAllOrderItems(Integer customerCartId);
	CustomerCart addCart(CustomerCart cart);
	CustomerCart addItemToCart(Integer customerCartId, OrderItem item);
	CustomerCart deleteItemFromCart(Integer customerCartId, Integer orderItemId);
}
