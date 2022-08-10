package com.example.demo.controllers;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Users;
import com.example.demo.service.UserService;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/security/login")
	public String login(Model model) {
//    	model.addAttribute("main", "products/list");
		return "security/login";
	}

	@GetMapping("/security/success")
	public String loginSucsess(Model model) {

		System.out.println("login thành công");
		return "products/list";
	}

	@RequestMapping("/security/logout/seccsus")
	public String logout(Model model) {
//	    	model.addAttribute("main", "products/list");

		return "security/login";
	}

	@RequestMapping("/secrutity/registers")
	public String register() {
//    	model.addAttribute("main", "products/list");
		return "security/register";
	}

	
//	@RequestMapping("/home/page")
//	public String page(Model model) {
//		model.addAttribute("message", "đây là giới thiệu");
//		return "web/index";
//	}

//	@RequestMapping("/home/admin")
//	public String admins(Model model) {
//		model.addAttribute("message", "hello adminstrafor");
//		return "web/index";
//	}

//	@RequestMapping("/home/users")
//	public String users(Model model) {
//		model.addAttribute("message", "hello users");
//		return "web/index";
//	}
//	
//	@RequestMapping("/home/autheticated")
//	public String autheticated(Model model) {
//		model.addAttribute("message", "hello autheticated");
//		return "web/index";
//	}

//	@RequestMapping("/home/login")
//	public String login (Model model) {
//		model.addAttribute("message", "truy cập thành công");
//		return "home/login";
//	}
//	
//	@RequestMapping("/home/logoff")
//	public String logoff (Model model) {
//		
//		model.addAttribute("message", "đăng xuất");
//		return "home/logoff";
//		
//	}
//	
//	@RequestMapping("/login/success")
//	public String success(OAuth2AuthenticationToken oauth2,Model model) {
//		
//		model.addAttribute("message", "đn tc");
//		return  "redirect:/login/success";
//		
//	}

//	@RequestMapping("login")
//     public String loginform (Model model) {
//		
//	
//		return "security/login";
//		
//	}

}
