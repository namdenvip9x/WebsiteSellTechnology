package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.DetailsOrders;

public interface OrdersDetails extends JpaRepository<DetailsOrders,Integer> {
	@Query("select d from DetailsOrders d where d.orders.id_orders =?1")
	public List<DetailsOrders> findByOrders(Integer id);
	
}