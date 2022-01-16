package com.techwave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	private Integer studId;
	@Column(length=20)
	private String studName;
	@Column(length=100)
	private String address;
}
