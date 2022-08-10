package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entities.Products;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService  {
    
	@Autowired
	private ProductDao productdao;

	@Override
	public List<Products> findAll() {
		return productdao.findAll();
	}

	@Override
	public Products findByid(Integer id) {
		// TODO Auto-generated method stub
		return productdao.findById(id).get();
		
	}

	@Override
	public Products create(Products product) {
		// TODO Auto-generated method stub
		return productdao.save(product);
	}

	@Override
	public Products update(Products product) {
		// TODO Auto-generated method stub
		return productdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		
		productdao.deleteById(id);
	}



	@Override
	public List<Products> findByCategories(Integer id) {
		// TODO Auto-generated method stub
		return productdao.findByCategories(id);

	}
	
	 
}
