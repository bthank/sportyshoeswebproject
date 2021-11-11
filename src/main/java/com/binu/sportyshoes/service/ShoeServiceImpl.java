package com.binu.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Shoe;
import com.binu.sportyshoes.repository.ShoeRepository;

@Service
public class ShoeServiceImpl implements ShoeService {

	@Autowired
	ShoeRepository shoeRepository;
	
	public List<Shoe> getAllShoes() {
		List<Shoe> listShoes = shoeRepository.findAll();
		return listShoes;
	}
	
	@Transactional
	public Shoe addShoeToInventory(Shoe shoe) {
		Shoe addedShoe = shoeRepository.save(shoe);
		
		return addedShoe;
		
	}

	@Override
	public Shoe findById(Integer id) {
		Shoe shoe = shoeRepository.findById(id).get();
		return shoe;
	}
	
	
	
}
