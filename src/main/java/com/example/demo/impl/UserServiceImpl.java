package com.example.demo.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDao;
import com.example.demo.entities.Users;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersDao userdao;

	@Override
	public Users findByid(String acount) {
		return userdao.findById(acount).get();
	}
	

	@Override
	public List<Users> findAll() {
		return userdao.findAll();
	}

	@Override
	public Users create(Users users) {
		return userdao.save(users);
	}

	
	@Override
	public Users update(Users users) {
		return userdao.save(users);
	}

	@Override
	public void deleteById( String acount) {
		 userdao.deleteById(acount);
		
	}


	@Override
	public List<Users> getAdminstratos() {
		return userdao.getAdminstrators();
	}
	
	
	

	
	
	



}
