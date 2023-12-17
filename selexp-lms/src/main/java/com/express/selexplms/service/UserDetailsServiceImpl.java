package com.express.selexplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.express.selexplms.dao.CustomUserDAO;
import com.express.selexplms.entity.MyAppUser;

@Component
public class UserDetailsServiceImpl implements UserDetailsManager {

	@Autowired
	private CustomUserDAO customUserDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("loadUserByUsername");
		
		
		UserDetails loadUserByUsername = customUserDAO.loadUserByUsername(username);

		return loadUserByUsername;
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

		MyAppUser myAppUser = (MyAppUser) user;

		System.out.println(myAppUser);

		customUserDAO.save(myAppUser);

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
