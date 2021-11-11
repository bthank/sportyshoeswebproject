package com.binu.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Shipping;
import com.binu.sportyshoes.repository.ShippingRepository;

@Service
public class ShippingServiceImpl implements ShippingService{

	@Autowired
	ShippingRepository shippingRepository;
	
	
	@Override
	public Shipping getShippingById(String shippingId) {
		Shipping shipping = shippingRepository.findById(shippingId).get();
		return shipping;
	}


	@Override
	public List<Shipping> getAllShipping() {
		List<Shipping> listOfShipping = shippingRepository.findAll();
		return listOfShipping;
	}

}
