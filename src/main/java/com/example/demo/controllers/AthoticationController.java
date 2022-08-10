package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AthoticationDao;
import com.example.demo.entities.Athorities;
import com.example.demo.service.AthoritiesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/athoritities")
public class AthoticationController {
	
	@Autowired
	private AthoritiesService athoritiService;
	
	@GetMapping
	public List<Athorities> getAll(@RequestParam("admin") Optional<Boolean> admin ) {
		if (admin.orElse(false)) {
			return athoritiService.listAthorities();
		}
		return athoritiService.findAll();
	}
	
	@PostMapping
	public Athorities create(@RequestBody Athorities auth) {
		return athoritiService.create(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		athoritiService.delete(id);
	}
	
	
	
	

}
