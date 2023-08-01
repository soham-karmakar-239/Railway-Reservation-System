package com.rrs.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Refund entity*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Refund {

	/** the refund id*/
	@Id
	@GeneratedValue
	private long refundId;
	
	/** the payment details*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
	private PaymentDetails paymentDetails;
	
	/** the refund amount*/
	private double refundAmount;
	
	/** the user*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	
	/** the refund date*/
	private Date refundDate;
	
	/** the refund time */
	private Time refundTime;
}
