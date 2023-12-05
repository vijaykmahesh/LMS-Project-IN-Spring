package com.express.selexplms.lmscontrollers;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.selexplms.dto.RegistrationDTO;

@Controller
public class RegistrationController {

	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	PasswordEncoder passwordEncoder;

	@Lazy
	public RegistrationController(InMemoryUserDetailsManager inMemoryUserDetailsManager,
			PasswordEncoder passwordEncoder) {

		this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
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

		String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());

		UserDetails appUser = User.withUsername(registrationDTO.getUsername()).password(encodedPassword).roles("user")
				.build();

		inMemoryUserDetailsManager.createUser(appUser);

		return "registration sucessful for the user " + registrationDTO.getUsername();
	}

}
