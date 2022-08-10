package com.example.demo.entities;

import java.math.BigDecimal;

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
@Table(name ="detailsorders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsOrders {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   
   @Column
   private int quantity;
   
   @Column
   private BigDecimal price;
   
   
   @ManyToOne
   @JoinColumn(name= "id_order")
   public Orders orders;
   
   @ManyToOne
   @JoinColumn(name="product_id")
   private Products products;
}
