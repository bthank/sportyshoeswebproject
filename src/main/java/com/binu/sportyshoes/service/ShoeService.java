package com.binu.sportyshoes.service;

import java.util.List;

import com.binu.sportyshoes.dto.Shoe;
import com.binu.sportyshoes.dto.ShoeOrder;


public interface ShoeService{

	Shoe findById(Integer id);
	List<Shoe> getAllShoes();
	Shoe addShoeToInventory(Shoe shoe);
	
	
}