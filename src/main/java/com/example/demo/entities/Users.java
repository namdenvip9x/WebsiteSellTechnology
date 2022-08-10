package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

	
	@Id
	private String acount;
	
	@Column
	
	private String password;
	
	@Column
	private String fullname; 
	
	@Column
	@Email

	private String email;
	
	@Column 

    private String address;
	
	@Column
    private String photo;
	
	@Column
	
    private String phone;
	
	@Column
    private boolean gender;
	
	@JsonIgnore
	@OneToMany (mappedBy =  "user")
	private List<Categories> list_categories;
	
	@JsonIgnore
	@OneToMany (mappedBy = "user")
	private List<Products> list_products;
	
	@JsonIgnore
	@OneToMany (mappedBy = "user") 
	private List<Orders> orders;
	
	
	@JsonIgnore
	@OneToMany (mappedBy = "user")
	private List<Carts> list_cart;
	
	
	@JsonIgnore
	@OneToMany (mappedBy = "user",
	fetch = FetchType.EAGER)
	private List<Athorities> athorities;
	
	
	
	
	
    
}
