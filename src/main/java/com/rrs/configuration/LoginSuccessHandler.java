package com.rrs.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Configuration class to handle successful login
 * 
 * 
 */

@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * Gets authority of logged in user and redirects to particular home page
	 * 
	 * @param request        HttpServletRequest object,
	 * @param response       HttpServletResponse object,
	 * @param authentication Authentication object
	 * 
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ADMIN")) {
				response.sendRedirect("/admin/");
				return;
			}
			response.sendRedirect("/user/");
		}
	}

}