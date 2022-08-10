package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AthoticationDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.entities.Athorities;
import com.example.demo.entities.Users;
import com.example.demo.service.AthoritiesService;

@Service
public class AthoritiesImpl  implements AthoritiesService{

	
	@Autowired
	private AthoticationDao athoricationdao;
	
	@Autowired
	private UsersDao userdao;
	
	@Override
	public List<Athorities> findAll() {
		return  athoricationdao.findAll();
	}

	@Override
	public Optional<Athorities> findbyid(Integer id) {
		return athoricationdao.findById(id);
	}

	@Override
	public Athorities create(Athorities athorities) {
		return athoricationdao.save(athorities);
	}

	@Override
	public Athorities update(Athorities athorities) {
		return athoricationdao.save(athorities);
	}

	@Override
	public void delete(Integer id) {
		athoricationdao.deleteById(id);
		
	}

	@Override
	public List<Athorities> listAthorities() {
		List<Users> users = userdao.getAdminstrators();
		return athoricationdao.getAthoritiesOf(users);
	}
	
	
	
 
}
