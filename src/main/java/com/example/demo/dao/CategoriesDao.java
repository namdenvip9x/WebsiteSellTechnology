package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Categories;

public interface CategoriesDao extends JpaRepository<Categories, Integer> {

}
