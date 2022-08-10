package com.example.demo.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsersDao;
import com.example.demo.entities.Athorities;
import com.example.demo.entities.Users;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private UsersDao usserdao;

	@GetMapping()
	public List<Users> getAll() {
		return userService.findAll();
	}

	@GetMapping("{acount}")
	public Users getone(@PathVariable("acount") String acount) {
		return userService.findByid(acount);
	}

	@PostMapping
	public Users create(@RequestBody Users user) {
		return userService.create(user);
	}

	@PutMapping("{acount}")
	public Users update(@PathVariable("acount") String acount, @RequestBody Users user) {
		return userService.update(user);
	}

	@DeleteMapping("{acount}")
	public void delete(@PathVariable("acount") String acount) {
		userService.deleteById(acount);
	}
	
	
	
	

}