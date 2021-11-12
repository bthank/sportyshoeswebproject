package com.binu.sportyshoes.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.ShoeOrder;
import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.repository.ShoeOrderRepository;

@Service
public class ShoeOrderServiceImpl implements ShoeOrderService {

	@Autowired
	ShoeOrderRepository shoeOrderRepository;
	
	@Override
	public ShoeOrder getShoeOrderById(Integer id) {
		ShoeOrder shoeOrder = shoeOrderRepository.findById(id).get();
		return shoeOrder;
	}

	@Override
	public List<ShoeOrder> getAllShoeOrders() {
		List<ShoeOrder> listOfAllShoeOrders = shoeOrderRepository.findAll();
		return listOfAllShoeOrders;
	}

	@Transactional
	@Override
	public ShoeOrder addShoeOrder(ShoeOrder shoeOrder) {
		ShoeOrder savedShoeOrder = shoeOrderRepository.save(shoeOrder);
		return savedShoeOrder;
	}

	@Override
	public List<ShoeOrder> findByOrderType(String orderType) {
		List<ShoeOrder> listOfShoeOrders = shoeOrderRepository.findByOrderType(orderType);
		return listOfShoeOrders;
	}

	@Override
	public List<ShoeOrder> findByDateOfOrder(Date orderDate) {
		List<ShoeOrder> listOfShoeOrders = shoeOrderRepository.findByDateOfOrder(orderDate);
		return listOfShoeOrders;
	}

	@Override
	public List<ShoeOrder> findByDateOfOrderAndOrderType(Date orderDate, String orderType) {
		List<ShoeOrder> listOfShoeOrders = shoeOrderRepository.findByDateOfOrderAndOrderType(orderDate, orderType);
		return listOfShoeOrders;
	}

	 

}
