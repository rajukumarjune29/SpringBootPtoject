package com.techwave.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(length = 6)
	private Integer roleId;
	
	@Column(length = 30)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private List<User> users;
	
}
