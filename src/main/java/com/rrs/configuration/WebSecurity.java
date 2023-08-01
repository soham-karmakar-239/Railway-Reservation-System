package com.rrs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rrs.service.UserDetailsServiceImpl;

/**
 * Configuration class for Spring Security
 *
 * 
 */

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

	/**
	 * The UserServiceImpl object
	 *
	 * 
	 */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 * The LoginSuccessHandler object
	 *
	 * 
	 */
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	/**
	 * Creates the PasswordEncoder bean
	 * 
	 * @return BCryptPasswordEncoder object
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Creates the AuthenticationProvider Bean
	 *
	 * @return DaoAuthenticationProvider object
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	/**
	 * Sets userDetailsService of AuthenticationManagerBuilder
	 * 
	 * @param auth the AuthenticationManagerBuilder object
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	/**
	 * Configures HttpSecurity object for authorization and custom login
	 * 
	 * @param http the HttpSecurity object
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN").antMatchers("/user/**")
				.hasAuthority("USER").and().formLogin().loginPage("/login").loginProcessingUrl("/login")
				.successHandler(loginSuccessHandler);
	}

}
