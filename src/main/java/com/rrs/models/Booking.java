package com.rrs.models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.rrs.dto.BookingDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Booking entity*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Booking {

	/** the pnr number */
	@Id
	@GeneratedValue
	private long pnr;

	/** the departure date */
	private Date departureDate;

	/** the seat class */
	private String seatClass;

	/** the payment details */
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
	private PaymentDetails paymentDetails;

	/** the user */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "userId")
	private User user;

	/** the price */
	private int price;

	/** the train */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trainno", referencedColumnName = "trainNo")
	private Train train;

	/** the booking date */
	private Date bookingDate;

	/** the booking time */
	private Time bookingTime;

	/**
	 * Instantiates and initializes Booking object from BookingDto, PaymentDetails,
	 * User, Train objects
	 */
	public Booking(BookingDto bookingDto, PaymentDetails paymentDetails, User user, Train train) {
		this.departureDate = bookingDto.getDepartureDate();
		this.seatClass = bookingDto.getSeatClass();
		this.paymentDetails = paymentDetails;
		this.user = user;
		this.train = train;
		this.price = bookingDto.getPrice();
		this.bookingDate = Date.valueOf(LocalDate.now());
		this.bookingTime = Time.valueOf(LocalTime.now());
	}

}