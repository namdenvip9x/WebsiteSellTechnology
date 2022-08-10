package com.example.demo.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RequestMapping("/rest/user")
@RestController
public class UserRestControllerByAthorities {
    
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<Users> getAll(@RequestParam("admin") Optional<Boolean> admin ) {
		if (admin.orElse(false)) {
			return userService.getAdminstratos();
		}
		return userService.findAll();
	}
	
}
