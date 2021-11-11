package com.binu.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.CustomerCart;

@Repository
public interface CustomerCartRepository extends JpaRepository<CustomerCart, Integer> {

}
