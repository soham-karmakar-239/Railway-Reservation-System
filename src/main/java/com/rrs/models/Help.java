package com.rrs.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Help entity*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Help {
	
	/** the id of raised ticket*/
	@Id
	@GeneratedValue
	private long ticketId;
	
	/** the isuue*/
	private String issue;
	
	/** the description*/
	private String description;
	
	/** the date created */
	private Date dateCreated;
	
	/** the resolution*/
	private String resolution;
	
	/** the user*/
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName="userId")
	private User user;
	
}
