package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Products;

public interface ProductService   {

   public List<Products> findAll();

   public Products findByid(Integer id);

   public Products create(Products product);

   public Products update(Products product);

   public void delete(Integer id);
   
   public List<Products> findByCategories(Integer  id);
  

	  
}
