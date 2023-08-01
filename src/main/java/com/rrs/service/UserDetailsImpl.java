package com.rrs.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rrs.models.User;

import lombok.AllArgsConstructor;

/** The Implementation of UserDetails Interface */
@AllArgsConstructor
@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails {

	/** The User */
	private User user;

	/** gets the authorities of the Principal user */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(user.getUserCategory().toUpperCase()));
	}

	/** gets the password */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/** gets the username */
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
