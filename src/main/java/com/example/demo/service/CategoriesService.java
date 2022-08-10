package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Categories;

public interface CategoriesService {
	
	public List<Categories> findAll();

	public Categories create(Categories cate);

	public void delete(Integer id);
	
	public Categories update(Categories cate);


	Optional<Categories> findByid(Integer id);




}
