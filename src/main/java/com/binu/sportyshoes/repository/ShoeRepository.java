package com.binu.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.Shoe;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

}
