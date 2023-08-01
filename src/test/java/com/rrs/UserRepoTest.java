package com.rrs;

import org.assertj.core.api.Assertions;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.User;
import com.rrs.repositories.UserRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepoTest {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	public void registerUserTest() {
		User user = User.builder()
						.firstName("Rakesh")
						.lastName("Roshan")
						.contactNo(9874563214L)
						.gender("Male")
						.dob(Date.valueOf("2022-05-05"))
						.email("soumya@gmail.com")
						.username("Hrittik")
						.password("12345")
						.userCategory("User")
						.securityAnswer1("ABC")
						.securityAnswer2("PQR")
						.securityAnswer3("XYZ")
						.build();
		userRepo.save(user);
		Assertions.assertThat(user.getUserId()).isGreaterThan(0L);
		
	}
	
	@Test
	public void loginUserTest() {
		User user = userRepo.findById(1L).get();
		Assertions.assertThat(user.getUserId()).isEqualTo(1);
	}
	
	@Test
	public void resetPasswordTest() {
		User user = userRepo.findById(1L).get();
		user.setPassword("Qwerty");
		Assertions.assertThat(user.getPassword()).isEqualTo("Qwerty");
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> user= userRepo.findAll();
		Assertions.assertThat(user.size()).isGreaterThan(0);
	}
}
