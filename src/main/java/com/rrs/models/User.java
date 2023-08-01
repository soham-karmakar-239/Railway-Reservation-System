package com.rrs.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The User entity*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User {

	/** the user id*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	/** the first name*/
	private String firstName;
	
	/** the last name*/
	private String lastName;
	
	/** the gender*/
	private String gender;
	
	/** the date of birth*/
	private Date dob;
	
	/** the email id*/
	private String email;
	
	/** the contact number*/
	private long contactNo;
	
	/** the username*/
	@Column(unique = true)
	private String username;
	
	/** the password*/
	private String password;
	
	/** the user category*/
	private String userCategory;
	
	/** the answer to security question 1*/
	private String securityAnswer1;
	
	/** the answer to security question 2*/
	private String securityAnswer2;
	
	/** the answer to security question 3*/
	private String securityAnswer3;

	/** the bookings*/
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Booking> bookings;

	/** the refunds*/
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Refund> refunds;
	
	/** the raised tickets*/
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Help> helps;
	
}
