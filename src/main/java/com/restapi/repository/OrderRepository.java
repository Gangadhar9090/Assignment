package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
