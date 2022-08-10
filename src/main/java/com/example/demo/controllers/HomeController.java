package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// trả về trang chủ chính theo spa
//	 @RequestMapping({"view","/view/home/layout"})
//	 public String layout() {
//		 return "redirect:/asserts/view/layout.html";
//	 }
	// angular js router
	@RequestMapping({ "admin", "/admin/index" })
	public String layout() {
		return "redirect:/asserts/admin/index.html";
	}

}
