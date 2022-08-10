package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nameproduct;
	@Column
	private BigDecimal price;
	@Column
	private String images;
	@Column
	@Temporal (TemporalType.DATE)
	private Date date;
	@Column
	private boolean status;
	 
	@Column
	private String configutation;
	
	@Column
	private int quantity;
	
	@ManyToOne 
	@JoinColumn( name = "acount")
	private Users user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "products")
	private List<Carts> list_carts;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Categories categories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "products")
	private List<DetailsOrders> list_orderdetail;
	
}
