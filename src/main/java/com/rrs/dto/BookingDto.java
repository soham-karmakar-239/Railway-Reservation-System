package com.rrs.dto;

import java.sql.Date;

import com.rrs.models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/** DTO to store booking details */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private User user;
	private long trainNo;
	private String seatClass;
	private Date departureDate;
	private String cardNo;
	private String cardHolderName;
	private int expiryMonth;
	private int expiryYear;
	private int cvv;
	private int price;

}
