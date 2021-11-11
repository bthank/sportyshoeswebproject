package com.binu.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.CustomerCart;
import com.binu.sportyshoes.dto.OrderItem;
import com.binu.sportyshoes.dto.Shoe;
import com.binu.sportyshoes.repository.CustomerCartRepository;
import com.binu.sportyshoes.repository.OrderItemRepository;
import com.binu.sportyshoes.repository.ShoeRepository;

@Service
public class CustomerCartServiceImpl implements CustomerCartService {

	@Autowired
	CustomerCartRepository customerCartRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ShoeRepository shoeRepository;
	
	@Override
	public List<OrderItem> getAllOrderItems(Integer customerCartId) {
		List<OrderItem> listOfAllOrderItems = customerCartRepository.findById(customerCartId).get().getOrderItems();
				
		return listOfAllOrderItems;
	}
	

	@Transactional
	@Override
	public CustomerCart addCart(CustomerCart cart) {
		CustomerCart saved_cart = customerCartRepository.save(cart); 
		return saved_cart;
	}
	
	
	@Transactional
	@Override
	public CustomerCart addItemToCart(Integer customerCartId, OrderItem item) {
		System.out.println("In CustomerCartServiceImpl:1  addItemToCart()    customerCartId=" + customerCartId + "     item=" + item);
		Shoe shoe = shoeRepository.findById(item.getShoeId()).get();
		item.setShoeName(shoe.getShoeName());
		item.setImageUrl(shoe.getImageUrl());
		item.setPrice(shoe.getMarketPrice());
		
		OrderItem itemCreated = orderItemRepository.save(item);
		System.out.println("In CustomerCartServiceImpl:2  addItemToCart()    itemCreated=" + itemCreated);
		CustomerCart cart = customerCartRepository.findById(customerCartId).get();
		System.out.println("In CustomerCartServiceImpl:3  addItemToCart()    cart=" + cart);
		cart.getOrderItems().add(itemCreated);
		CustomerCart updatedCart = customerCartRepository.save(cart);
		System.out.println("In CustomerCartServiceImpl:4  addItemToCart()    updatedCart=" + updatedCart);
		return updatedCart;
	}


	@Override
	public CustomerCart deleteItemFromCart(Integer customerCartId, Integer orderItemId) {
		System.out.println("In CustomerCartServiceImpl:1  deleteItemFromCart()    customerCartId=" + customerCartId + "     orderItemId=" + orderItemId);
		// 
		OrderItem item = orderItemRepository.findById(orderItemId).get(); 
		CustomerCart cart = customerCartRepository.findById(customerCartId).get();
		System.out.println("In CustomerCartServiceImpl:3a  deleteItemFromCart()  before deleting  cart=" + cart + "     item=" + item);
		// remove item from cart
		boolean item_deleted = cart.getOrderItems().remove(item);
		System.out.println("In CustomerCartServiceImpl:3b  deleteItemFromCart()  item_deleted=" + item_deleted + "     after deleting  cart=" + cart);
		// delete item from order item table
		orderItemRepository.delete(item);
		// save the updated cart
		CustomerCart updatedCart = customerCartRepository.save(cart);
		System.out.println("In CustomerCartServiceImpl:4  deleteItemFromCart()    updatedCart=" + updatedCart);
		return updatedCart;
	}







}
