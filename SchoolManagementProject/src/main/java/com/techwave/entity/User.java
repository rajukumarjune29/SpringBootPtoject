package com.techwave.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="S_USER")
public class User implements UserDetails,Serializable{

	@Id
	@Column(length = 30)
	private String userId;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 200)
	private String password;
	
	@ManyToOne(targetEntity = Profile.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="profileId",referencedColumnName = "profileId")
	@JsonManagedReference
	@JsonIgnore
	private Profile profile;
	
	private Boolean active;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UserServiceRole",joinColumns = {@JoinColumn(name="userId")},
	inverseJoinColumns = {@JoinColumn(name="roleId")})
	@JsonManagedReference
	@JsonIgnore
	private List<Role> roles;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UserServiceRole",joinColumns = {@JoinColumn(name="userId")},
	inverseJoinColumns = {@JoinColumn(name="serviceId")})
	@JsonManagedReference
	@JsonIgnore
	private List<Service> services;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.getRoles();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
