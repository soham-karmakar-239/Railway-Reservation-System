package com.rrs.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.dto.HelpDto;
import com.rrs.models.Help;
import com.rrs.models.User;
import com.rrs.repositories.HelpRepo;
import com.rrs.repositories.UserRepo;

/** The Help Service class */
@Service
public class HelpService {

	/** the User Repository */
	@Autowired
	private UserRepo userRepo;

	/** the Help Rpository */
	@Autowired
	private HelpRepo helpRepo;

	/**
	 * gets tickets raised by an user
	 *
	 * @param username the username
	 * @return List of HelpDTO
	 */
	public List<HelpDto> getTicketsByUsername(String username) {
		long userId = userRepo.findByUsername(username).getUserId();
		List<Help> helpRequests = helpRepo.findByUserId(userId);
		List<HelpDto> tickets = new ArrayList<>();
		for (Help help : helpRequests) {
			HelpDto ticket = new HelpDto(help);
			tickets.add(ticket);
		}
		return tickets;
	}

	/**
	 * creates a new ticket
	 *
	 * @param issue       the issue
	 * @param description the description
	 * @param username    the username
	 */
	public void createTicket(String issue, String description, String username) {

		Help help = new Help();
		help.setIssue(issue);
		help.setDescription(description);
		help.setDateCreated(Date.valueOf(LocalDate.now()));
		help.setUser(userRepo.findByUsername(username));
		help.setResolution("");
		helpRepo.save(help);

	}

	/**
	 * gets unresolved tickets
	 *
	 * @return List of HelpDTO
	 */
	public List<HelpDto> getUnresolvesTickets() {
		String resolution = "";
		return helpRepo.findUnresolvedTickets(resolution);
	}

	/**
	 * gets a raised ticket by id
	 *
	 * @param ticketId the id number of the ticket
	 * @return HelpDTO
	 */
	public HelpDto getTicketById(long ticketId) {
		Help help = helpRepo.findById(ticketId).get();
		HelpDto helpDto = new HelpDto(help);
		return helpDto;
	}

	/**
	 * gets username of the user for a ticket id number
	 *
	 * @param ticketId the id number of the ticket
	 * @return the username
	 */
	public String getUsername(long ticketId) {

		Help help = helpRepo.findById(ticketId).get();
		User user = help.getUser();
		return user.getUsername();
	}

	/**
	 * adds a resolution for a ticket
	 *
	 * @param ticketId   the id number of the ticket
	 * @param resolution the resolution
	 */
	public void addResolution(long ticketId, String resolution) {

		Help help = helpRepo.findById(ticketId).get();
		help.setResolution(resolution);
		helpRepo.save(help);

	}

}
