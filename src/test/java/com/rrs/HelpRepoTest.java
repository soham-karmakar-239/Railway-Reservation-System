package com.rrs;

import java.sql.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.Help;
import com.rrs.models.User;
import com.rrs.repositories.HelpRepo;
import com.rrs.repositories.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class HelpRepoTest {

	@Autowired
	private HelpRepo helpRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	public void newTicketTest() {
		User user = userRepo.findById(1L).get();
		
		Help help = Help.builder()
						.ticketId(69)
						.dateCreated(Date.valueOf("2022-05-24"))
						.issue("Cancellations")
						.description("Something")
						.user(user)
						.build();
		helpRepo.save(help);
		Assertions.assertThat(help.getTicketId()).isEqualTo(69);
	}
	
	@Test
	public void resolveTicketTest() {
		Help help = helpRepo.findById(39L).get();
		help.setResolution("Do This");
		Help resolve = helpRepo.save(help);
		Assertions.assertThat(resolve.getResolution()).isEqualTo("Do This");
	}
	
	@Test
	public void showAllTickets() {
		List<Help> help = helpRepo.findAll();
		Assertions.assertThat(help.size()).isGreaterThan(0);
	}
}
