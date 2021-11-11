package com.binu.sportyshoes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Address;
import com.binu.sportyshoes.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepository;

	@Transactional
	@Override
	public Address addAddress(Address address) {
		Address savedAddress = addressRepository.save(address);
		return savedAddress;
	}

	@Override
	public Address getAddressById(int id) {
		Address address = addressRepository.findById(id).get();
		return address;
	}

}
