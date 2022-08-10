package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Role;
import com.example.demo.service.RolesService;

@CrossOrigin("*")
@RequestMapping("/rest/role")
@RestController
public class RoleRestController {

	@Autowired
	private RolesService roleService;
	
	@GetMapping
	public List<Role> getAll(){
		return  roleService.findAll();
	}
	
}
