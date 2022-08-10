package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDetails;
import com.example.demo.entities.DetailsOrders;
import com.example.demo.service.OrderDetailService;

@Service
public class OrderDetailImpl implements OrderDetailService{
 
	@Autowired
	private OrdersDetails orderDetailDao;

	@Override
	public List<DetailsOrders>  findById(Integer id) {
		return orderDetailDao.findAll();
	}

	@Override
	public List<DetailsOrders> findByOrders(Integer id) {
		// TODO Auto-generated method stub
		return orderDetailDao.findByOrders(id);
	}

	
	
}
