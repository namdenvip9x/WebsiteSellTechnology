package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Users;


public interface UserService {

	public Users findByid(String acount);

	public List<Users> findAll();

	public Users create(Users users);

	

	public Users update(Users user);

	public void deleteById(String  user);
	
	public List<Users> getAdminstratos();
	
}
