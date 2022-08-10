package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Athorities;
import com.example.demo.entities.Users;


public interface AthoticationDao extends JpaRepository<Athorities, Integer>{
	 
	@Query("SELECT DISTINCT a FROM Athorities a where a.user IN ?1")
	public  List<Athorities> getAthoritiesOf(List<Users> users);

}
