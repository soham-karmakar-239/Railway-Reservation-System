package com.rrs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrs.models.User;

/** The User Repository*/
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	/** finds user by username*/
	public User findByUsername(String username);

}
