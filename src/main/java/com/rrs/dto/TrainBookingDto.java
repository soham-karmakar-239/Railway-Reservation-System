package com.rrs.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** DTO to store booking details */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainBookingDto {

	private TrainDto train;
	private Date departureDate;
	private long userId;
	private String seatClass;
	
}
