package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.DetailsOrders;
import com.example.demo.entities.Orders;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrdersService;

@RequestMapping("/order/")
@Controller
public class OrderController {
	
	@Autowired
    private OrderDetailService orderDetailService;
   
	@Autowired
	private OrdersService orderService;
	
	
	@GetMapping("checkout")
	public String checkout() {
		return "/order/checkout";
	}
	
	@GetMapping("list")
	public String list(Model model, HttpServletRequest request) {
		String acount = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByAcount(acount));
	
		return "/order/list";
	}
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Integer id,Model model) {
		
		model.addAttribute("orderdetails", orderDetailService.findByOrders(id));
		return "/order/details";
	} 
	
	
	
	
	 
}
