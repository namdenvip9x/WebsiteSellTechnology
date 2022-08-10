package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{

	@Query("select o from  Orders o where  o.user.acount = ?1")
	public List<Orders> findByAcount(String acount);
}
