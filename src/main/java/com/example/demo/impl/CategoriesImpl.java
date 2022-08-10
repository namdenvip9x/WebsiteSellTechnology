package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.entities.Categories;
import com.example.demo.service.CategoriesService;

@Service
public class CategoriesImpl  implements CategoriesService{

	@Autowired
	CategoriesDao catedao;

	@Override
	public List<Categories> findAll() {
		return catedao.findAll();
	}
	
	@Override
	public Categories create(Categories cate) {
		return catedao.save(cate);
	}
	
	@Override
	public void delete(Integer id) {
		catedao.deleteById(id);
	}

	@Override
	public Categories update(Categories cate) {
		return catedao.save(cate);
	}

	

	@Override
	public Optional<Categories> findByid(Integer id) {
		// TODO Auto-generated method stub
		return catedao.findById(id);
	}
	

	
	
}
