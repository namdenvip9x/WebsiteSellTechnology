package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.DetailsOrders;
import com.example.demo.entities.Orders;

public interface OrderDetailService {

	public List<DetailsOrders> findById(Integer id);

	public List<DetailsOrders> findByOrders(Integer id);
 
	
}
