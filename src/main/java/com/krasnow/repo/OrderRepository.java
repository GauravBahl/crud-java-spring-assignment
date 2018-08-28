package com.krasnow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krasnow.dao.Orders;

public interface OrderRepository extends JpaRepository<Orders, String>{
	
	List<Orders> findByEmail(String email);
	
}
