package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NegativeOrZero;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders  implements Serializable{
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Integer id_orders;
	
	@Column
	private  Date createdate;
	
	
	@Column 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private BigDecimal totalmoney;
	
	@Column
	private String address;
	
	@ManyToOne
	@JoinColumn(name="acount")
	private Users user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	public List<DetailsOrders> orderDetails;
	
}
