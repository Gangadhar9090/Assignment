package com.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restapi.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query("from Item where orderId=:orderId")
	
	public List<Item> findAllById(@Param("orderId") int orderId);

}
