package com.rrs.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.rrs.dto.BookingDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The PaymentDetails Entity*/

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

	/** the payment id*/
	@Id
	@GeneratedValue
	private long paymentId;
	
	/** the booking*/
	@OneToOne(mappedBy = "paymentDetails")
	private Booking booking;
	
	/** the refunds*/
	@OneToMany(mappedBy = "paymentDetails")
	private Set<Refund> refunds;
	
	/** the card number*/
	private String cardNo;
	
	/** the card holder name*/
	private String cardHolderName;
	
	/** the expiry month*/
	private int expiryMonth;
	
	/** the expiry year*/
	private int expiryYear;
	
	/** the cvv*/
	private int cvv;

	/** Instantiates and initializes PaymentDetails object from BookingDto object*/
	public PaymentDetails(BookingDto bookingDto) {
		this.cardNo = bookingDto.getCardNo();
		this.cardHolderName = bookingDto.getCardHolderName();
		this.expiryMonth = bookingDto.getExpiryMonth();
		this.expiryYear = bookingDto.getExpiryYear();
		this.cvv = bookingDto.getCvv();
	}
}