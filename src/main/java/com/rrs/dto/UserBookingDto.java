package com.rrs.dto;

import java.sql.Date;
import java.sql.Time;

import com.rrs.models.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** DTO to store booking details*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBookingDto {

	private long pnr;
	private long trainNo;
	private String trainName;
	private Date departureDate;
	private Time departureTime;
	private String fromStation;
	private Time arrivalTime;
	private String toStation;
	private String seatClass;
	private long paymentId;
	private String cardNo;
	private int price;
	private Date bookingDate;
	private Time bookingTime;

	/** Instantiates and initializes UserBookingDto object from Booking object*/
	
	public UserBookingDto(Booking booking) {
		this.pnr = booking.getPnr();
		this.trainNo = booking.getTrain().getTrainNo();
		this.trainName = booking.getTrain().getTrainName();
		this.departureDate = booking.getDepartureDate();
		this.departureTime = booking.getTrain().getDepartureTime();
		this.fromStation = booking.getTrain().getSourceStn();
		this.arrivalTime = booking.getTrain().getArrivalTime();
		this.toStation = booking.getTrain().getDestinationStn();
		this.seatClass = booking.getSeatClass();
		this.paymentId = booking.getPaymentDetails().getPaymentId();
		this.cardNo = booking.getPaymentDetails().getCardNo();
		this.price = booking.getPrice();
		this.bookingDate = booking.getBookingDate();
		this.bookingTime = booking.getBookingTime();
	}

}
