package com.example.demo.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
	
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer id;
    
    @Column    
    private String namecategories;
    
 
    @ManyToOne
    @JoinColumn (name = "acount")
    private Users user;
    
    @JsonIgnore
    @OneToMany (mappedBy= "categories")
    private List<Products> list_product;

}
 