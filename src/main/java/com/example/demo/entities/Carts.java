package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id_carts;
	
	@Column
	private int quantity;

	
	@Column 
	private int hide;
	
	@ManyToOne
	@JoinColumn(name="acount")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="product_id",referencedColumnName = "id")
	private Products products;
		
	
	
	
}
