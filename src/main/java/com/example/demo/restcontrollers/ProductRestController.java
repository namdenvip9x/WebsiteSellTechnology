package com.example.demo.restcontrollers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Products;
import com.example.demo.entities.Users;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	private ProductService productSerrvice;
	
	
	
	@GetMapping()
	public  List<Products> findAll(){
	   return productSerrvice.findAll();
	}
	
	@GetMapping("{id}")
	public Products getOne(@PathVariable("id")Integer id) {
		return productSerrvice.findByid(id);
	}
	
	@PostMapping
	public Products create(@RequestBody Products product) { 
		product.setDate(new Date());
		return productSerrvice.create(product);
	}
	
	@PutMapping("{id}")
	public Products update(@PathVariable("id") Integer id,@RequestBody Products product) {
		return  productSerrvice.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productSerrvice.delete(id);
	}
	
	
}
