package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Orders;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrdersService {
	 
	public  List<Orders> findAll();
	 
	public  Orders create(Orders order);
	
	public  void delete(Integer id );
	
	public Orders addOrder(JsonNode  data);

	public List<Orders> findByAcount(String acount);
	
	public Orders findById(Integer id);
	


	

}
