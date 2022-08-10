package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name= "athorities", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"acount","roleid"} )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Athorities implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "acount")
	private Users user;
	
}
