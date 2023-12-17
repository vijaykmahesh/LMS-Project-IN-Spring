package com.express.selexplms.lmscontrollers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.selexplms.dto.RegistrationDTO;
import com.express.selexplms.entity.MyAppUser;
import com.express.selexplms.service.UserDetailsServiceImpl;

@Controller
public class RegistrationController {

//	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	UserDetailsServiceImpl userDetailsServiceImpl;

	PasswordEncoder passwordEncoder;

	@Lazy
	public RegistrationController(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder) {

		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("reg") RegistrationDTO registrationDTO) {

		return "registration";
	}

	// /process-registration?user=digna&pass=digna
	@ResponseBody
	@PostMapping("/process-registration")
	public String processRegistrationPage(RegistrationDTO registrationDTO) {

//		String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
//
//		UserDetails appUser = User.withUsername(registrationDTO.getUsername()).password(encodedPassword).roles("user")
//				.build();
//
//		//inMemoryUserDetailsManager.createUser(appUser);

		
		
		String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
		
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		GrantedAuthority role1 = new SimpleGrantedAuthority("user");
		roles.add(role1);
		
		UserDetails appUser =  new MyAppUser(registrationDTO.getUsername(), encodedPassword,roles ,registrationDTO.getEmail());
		
		userDetailsServiceImpl.createUser(appUser);
		
		
		return "registration sucessful for the user " + registrationDTO.getUsername();
	}

}
