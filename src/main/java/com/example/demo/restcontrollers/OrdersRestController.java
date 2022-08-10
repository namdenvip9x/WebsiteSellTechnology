package com.example.demo.restcontrollers;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Orders;
import com.example.demo.service.OrdersService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrdersRestController {
 
	  @Autowired
	  private OrdersService ordersService;
	  	  
	  Orders order;
	  @PostMapping
	  public Orders create( @RequestBody JsonNode data) {
		    
		  return ordersService.addOrder(data);
	  }
	
	  
	  
}
