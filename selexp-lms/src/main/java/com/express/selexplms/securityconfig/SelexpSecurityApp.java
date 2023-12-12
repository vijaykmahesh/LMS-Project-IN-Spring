package com.express.selexplms.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class SelexpSecurityApp {
	
	@Autowired
	private HttpSecurity httpSecurity;

	@Bean
	public InMemoryUserDetailsManager setUpUser() {

		UserDetails vijay = User.withUsername("vijay")
				.password("$2a$04$XNvx/pdxzPIX70.YJkK/EO/tBPM2A7n.bZGyHFhAbQlSEcajtsRRy").roles("user").build();

		return new InMemoryUserDetailsManager(vijay);

	}

	@Bean
	public SecurityFilterChain settingUpHttpSecurity() throws Exception {

		httpSecurity.authorizeHttpRequests(customizer -> {

			customizer.requestMatchers("/register","/WEB-INF/view/**","/process-registration").permitAll()
			.anyRequest().authenticated();
		});

		httpSecurity.formLogin(loginCustomizer -> 
        										loginCustomizer.loginPage("/custom-login").permitAll()
										        .loginProcessingUrl("/process-login")
										        .defaultSuccessUrl("/instructor-info"))
		
					.logout(logoutCustomizer -> 
										        logoutCustomizer
										        .logoutUrl("/custom-logout").permitAll());
		
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		httpSecurity.csrf(csrfCustomizer -> csrfCustomizer.disable());

		return httpSecurity.build();

	}

	@Bean
	HandlerMappingIntrospector mvcHandlerMappingIntrospector() {

		return new HandlerMappingIntrospector();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}
}
