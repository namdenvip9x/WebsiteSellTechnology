package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.example.demo.dao.UsersDao;
import com.example.demo.entities.Users;
import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	 
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		auth.userDetailsService(account ->{

			try {
				
				Users user = userService.findByid(account);
				// tạo user
				
				String password =user.getPassword();
				String[] roles = user.getAthorities().stream()
					   .map(au -> au.getRole().getId())
					   .collect(Collectors.toList()).toArray(new String[0]);
			    System.out.println(roles);
			    
				return  User.withUsername(account)
						.password(pe.encode(password))
				        .roles(roles).build();
				
			} catch (Exception e) {
				throw new  UsernameNotFoundException("not found"+account);
			}
		});	  
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected  void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeHttpRequests()
		   .antMatchers("/product/**").authenticated()
		   .antMatchers("/order/**").authenticated()
		   .antMatchers("/admin/**").hasAnyRole("USER","ADMIN")
		   .antMatchers("/rest/authorities").hasRole("ADMIN")
		   .anyRequest().permitAll();
		   
		
		
		// điều khiển khi lỗi truy câp vai trò
	    
		  
	    http.formLogin()
	        .loginPage("/security/login")
	        .loginProcessingUrl("/security/success")
	        .defaultSuccessUrl("/security/success",false)
	        .failureUrl("/security/login?error=true")
	        .usernameParameter("acount")
	        .passwordParameter("password");
	    http.rememberMe()
	       .tokenValiditySeconds(0);
	    
		http.exceptionHandling()
		   .accessDeniedPage("/security/login");
		
		//Đăng xuất
	    
		http.logout()
		   .logoutUrl("/security/logout")
		   .logoutSuccessUrl("/security/logout/seccsus");
           
		
		//	    đăng nhập từ gogole

		http.oauth2Login()
		   .loginPage("/security/login")
		   .defaultSuccessUrl("/login/success",true)
		   .failureUrl("/home/index")
		   .authorizationEndpoint()
		      .baseUri("/oauth2/authorization");
		    
		
	}
	

	
	




}
