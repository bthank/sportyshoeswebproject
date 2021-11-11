package com.binu.sportyshoes.service;

import com.binu.sportyshoes.dto.Address;

public interface AddressService {

	Address addAddress(Address address);
	Address getAddressById(int id);
}
