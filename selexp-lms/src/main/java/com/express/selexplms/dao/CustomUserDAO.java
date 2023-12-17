package com.express.selexplms.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.express.selexplms.entity.MyAppUser;

public interface CustomUserDAO {

	void save(MyAppUser user);

	UserDetails loadUserByUsername(String username);

}
