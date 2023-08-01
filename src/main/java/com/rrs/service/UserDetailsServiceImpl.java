package com.rrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rrs.models.User;
import com.rrs.repositories.UserRepo;

/** The Implementation of UserDetailsService */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The User Repository */
	@Autowired
	private UserRepo userRepo;

	/**
	 * gets UserDetails object from username
	 * 
	 * @param username the username
	 * @return UserDetailsImpl object
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username not found");
		return new UserDetailsImpl(user);
	}

}
