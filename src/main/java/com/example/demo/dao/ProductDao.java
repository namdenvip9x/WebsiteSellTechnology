package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Products;

public interface ProductDao extends JpaRepository<Products, Integer>{
	@Query("select p from  Products p where p.categories.id = ?1")
	public List<Products> findByCategories(Integer  id);
	
}
