package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Products;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ProductService;

@Controller
public class ProductControllerUI {
   
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoriesService categoriesService;
	 
	
	// đẩy lên trang chủ
	@RequestMapping("/product/index")
	public String listproduct(Model model) {
		List<Categories> list_category= categoriesService.findAll();
		model.addAttribute("list", list_category);
		List<Products> list= productService.findAll();
		model.addAttribute("items", list);
		return "products/list";
	}
	@RequestMapping("/product/contact")
    public String contact() {
		return "contact/contact";
	}
	@RequestMapping("/product/shop")
    public String shop(Model model) {
		List<Categories> list_category= categoriesService.findAll();
		model.addAttribute("list", list_category);
		List<Products> list= productService.findAll();
		model.addAttribute("items", list);
		return "products/shop";
	}
	
	//lọc theo danh mục sản phẩm
	
	@RequestMapping("/product/shop/{id}")
	public String findbycate(Model model, @PathVariable("id")Integer  id) {
		List<Categories> list_category= categoriesService.findAll();
		model.addAttribute("list", list_category);
		List<Products> listproduct = productService.findByCategories(id);
		model.addAttribute("items", listproduct);
		return "products/shop";		
	}
	
	@RequestMapping("/product/detail/{id}")
	public String fingByDetail(@PathVariable("id")Integer id,Model model) {
		model.addAttribute("list",  productService.findByid(id));
		return "/products/detail";
	}

	
   
	
	
	
	 
	
}
