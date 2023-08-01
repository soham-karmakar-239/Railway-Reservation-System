package com.rrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rrs.models.User;
import com.rrs.repositories.UserRepo;

/** The User Service class */
@Service
public class UserService {

	/** the User Repository */
	@Autowired
	private UserRepo userRepo;

	/** the password encoder */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * registers a new user
	 * 
	 * @param user the new User
	 */
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUserCategory("User");
		userRepo.save(user);
	}

	/**
	 * verifies a user for password reset
	 * 
	 * @param username        the username,
	 * @param securityAnswer1 answer to first security question,
	 * @param securityAnswer2 answer to second security question,
	 * @param securityAnswer3 answer to third security question
	 * @return if user is verified
	 */
	public boolean verifyUser(String username, String securityAnswer1, String securityAnswer2, String securityAnswer3) {
		User user = userRepo.findByUsername(username);
		if (user == null)
			return false;
		if (user.getSecurityAnswer1().equalsIgnoreCase(securityAnswer1)
				&& user.getSecurityAnswer2().equalsIgnoreCase(securityAnswer2)
				&& user.getSecurityAnswer3().equalsIgnoreCase(securityAnswer3)) {
			return true;
		}
		return false;
	}

	/**
	 * updates the password for the user
	 * 
	 * @param username the username
	 * @param password the new password
	 */
	public void updateUser(String username, String password) {
		User user = userRepo.findByUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepo.save(user);
	}

	/**
	 * verifies if a username is unique
	 * 
	 * @param username the username
	 * @return if the username is unique
	 */
	public boolean verifyUniqueUsername(String username) {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			return true;
		}
		return false;
	}

}
