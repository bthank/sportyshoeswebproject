package com.binu.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.ShoeOrder;

@Repository
public interface ShoeOrderRepository extends JpaRepository<ShoeOrder, Integer>{

	List<ShoeOrder> findByOrderType(String orderType);
	
}
