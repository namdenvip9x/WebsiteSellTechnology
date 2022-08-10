package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.entities.Role;
import com.example.demo.service.RolesService;

@Service
public class RoleServiceImpl implements RolesService {

	@Autowired
	private RoleDao daorole;
	@Override
	public List<Role> findAll() {
		return daorole.findAll();
	}

	

}
