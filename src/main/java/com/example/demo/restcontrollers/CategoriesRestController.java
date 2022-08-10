package com.example.demo.restcontrollers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
import com.example.demo.entities.Users;
import com.example.demo.service.CategoriesService;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoriesRestController {

	@Autowired
	private CategoriesService cateService;

	
	
	@GetMapping()
	public List<Categories> all() {
		return cateService.findAll();
	}
	@GetMapping("{id}")
	public  Optional<Categories> getone(@PathVariable("id") Integer id) {
		
		return cateService.findByid(id);
	} 
	@PostMapping
	public Categories create(@RequestBody Categories cate) {
		return cateService.create(cate);
	}
	

	@PutMapping("{id}")
	public Categories update(@PathVariable("id") String id,@RequestBody Categories cate) {
		return cateService.update(cate);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
//		System.out.println(Integer.parseInt(id));
		cateService.delete(id);
	}
	

}
