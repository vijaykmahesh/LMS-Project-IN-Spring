package com.express.selexplms.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class MyAppUser extends User {
	

	private int id;
	
	private static final long serialVersionUID = 1L;

	private String email;

	public MyAppUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String email) {
		super(username, password, authorities);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}