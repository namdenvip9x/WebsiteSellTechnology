package com.example.demo.impl;

import java.math.BigDecimal;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDao;
import com.example.demo.dao.OrdersDetails;
import com.example.demo.dao.UsersDao;
import com.example.demo.entities.DetailsOrders;
import com.example.demo.entities.Orders;
import com.example.demo.service.OrdersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Service
public class OrdersImpl implements OrdersService  {

	@Autowired
	private OrdersDao orderDao;
	
	@Autowired
	private OrdersDetails orderDetailDao;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserServiceImpl userImpl;
	
	@Override
	public List<Orders> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Orders create(Orders order) {
		return orderDao.save(order);
	}
	
	

	@Override
	public void delete(Integer id) {
		orderDao.deleteById(id);
		
	}

	@Override
	public Orders addOrder(JsonNode data ) {
	
		ObjectMapper mapper = new ObjectMapper();
		Orders order = mapper.convertValue(data, Orders.class);
		String acount =request.getRemoteUser();
		order.setUser(userImpl.findByid(acount));
	
		orderDao.save(order);
		// thêm hóa đơn chi tiết 
		com.fasterxml.jackson.core.type.TypeReference<List<DetailsOrders>> type = 
				new com.fasterxml.jackson.core.type.TypeReference<List<DetailsOrders>>() {};
			
		List<DetailsOrders> details = mapper.convertValue(data.get("orderDetails"), type).stream().peek(
				d -> d.setOrders(order)).collect(Collectors.toList());
		orderDetailDao.saveAll(details);	
		return order;
	}

	@Override
	public List<Orders> findByAcount(String acount) {
		return orderDao.findByAcount(acount);
	}

	@Override
	public Orders findById(Integer id) {
		
		return orderDao.findById(id).get();
	}

}
