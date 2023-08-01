package com.rrs.dto;

import java.sql.Date;

import com.rrs.models.Help;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** DTO to store help requests/tickets */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HelpDto {

	/** Instantiates and initializes HelpDto object from Help object*/
	public HelpDto(Help help) {
		this.ticketId=help.getTicketId();
		this.issue=help.getIssue();
		this.description=help.getDescription();
		this.dateCreated=help.getDateCreated();
		this.resolution=help.getResolution();
	}
	private long ticketId;
	private String issue;
	private String description;
	private Date dateCreated;
	private String resolution;
}
