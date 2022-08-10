package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.tomcat.util.http.parser.Authorization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name="role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@JsonIgnore
	@OneToMany (mappedBy = "role")
	private List<Athorities> list_authorities;
	
	
	
	
	
}
