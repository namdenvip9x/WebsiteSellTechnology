package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.example.demo.entities.Athorities;
import com.example.demo.entities.Users;

public interface UsersDao extends JpaRepository<Users, String> {
	@Query("SELECT  ar.user FROM Athorities ar WHERE ar.role.id IN ('ADMIN','USER')")
    List<Users> getAdminstrators();
	
	@Query("select u from Users u where u.acount=?1")
	Users findByAcount(String name);
	
}
