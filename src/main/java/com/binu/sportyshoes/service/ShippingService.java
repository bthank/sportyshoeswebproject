package com.binu.sportyshoes.service;

import java.util.List;

import com.binu.sportyshoes.dto.Shipping;

public interface ShippingService {

	Shipping getShippingById(String shippingId);
	List<Shipping> getAllShipping();
	
}
