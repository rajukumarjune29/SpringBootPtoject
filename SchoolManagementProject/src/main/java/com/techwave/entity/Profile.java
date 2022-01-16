package com.techwave.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 6)
	private Integer profileId;
	
	@Column(length = 30)
	private String name;
	
	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name="profileId",referencedColumnName = "profileId")
	@JsonBackReference
	private List<User> users;
}
