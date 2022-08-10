package com.example.demo.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;


import com.example.demo.entities.Athorities;
import com.example.demo.entities.Users;
import com.example.demo.impl.AthoritiesImpl;

public interface AthoritiesService  {
	
	
	public List<Athorities> findAll();
	
	public  Optional<Athorities> findbyid(Integer id);
	
	public Athorities create(Athorities athorities);
	
	public Athorities update(Athorities athorities);
	
	public void delete(Integer id);
	
	public List<Athorities> listAthorities();
	
}
