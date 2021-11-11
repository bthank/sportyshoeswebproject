package com.binu.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, String> {

}
