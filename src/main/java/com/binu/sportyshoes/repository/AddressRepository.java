package com.binu.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
