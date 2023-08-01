package com.rrs.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.dto.BookingDto;
import com.rrs.dto.RefundDto;
import com.rrs.dto.UserBookingDto;
import com.rrs.models.Booking;
import com.rrs.models.PaymentDetails;
import com.rrs.models.Refund;
import com.rrs.models.Train;
import com.rrs.models.User;
import com.rrs.repositories.BookingRepo;
import com.rrs.repositories.PaymentDetailsRepo;
import com.rrs.repositories.RefundRepo;
import com.rrs.repositories.TrainRepo;
import com.rrs.repositories.UserRepo;

/** The Booking Service class */
@Service
public class BookingService {

	/** the PaymentDetails Repository */
	@Autowired
	private PaymentDetailsRepo paymentDetailsRepo;

	/** the Booking Repository */
	@Autowired
	private BookingRepo bookingRepo;

	/** the User Repository */
	@Autowired
	private UserRepo userRepo;

	/** the Train Repository */
	@Autowired
	private TrainRepo trainRepo;

	/** the Refund Repository */
	@Autowired
	private RefundRepo refundRepo;

	/**
	 * Creates new Booking
	 * 
	 * @param bookingDto the Booking DTO
	 * @param username   the username
	 */
	public void createNewBooking(BookingDto bookingDto, String username) {
		PaymentDetails paymentDetails = new PaymentDetails(bookingDto);
		User user = userRepo.findByUsername(username);
		Train train = trainRepo.findById(bookingDto.getTrainNo()).get();
		Booking booking = new Booking(bookingDto, paymentDetailsRepo.save(paymentDetails), user, train);
		bookingRepo.save(booking);
	}

	/**
	 * Cancels a booking
	 * 
	 * @param pnr the pnr number of the booking
	 */
	public void cancelBooking(long pnr) {

		Booking booking = bookingRepo.findById(pnr).get();

		int price = booking.getPrice();

		Date currentDate = new java.util.Date();
		Date departureDate = booking.getDepartureDate();
		Date departureTime = booking.getTrain().getDepartureTime();

		double refundAmount = calculateRefundAmount(currentDate, departureDate, departureTime, price);

		PaymentDetails paymentDetails = booking.getPaymentDetails();
		User user = booking.getUser();
		java.sql.Date refundDate = java.sql.Date.valueOf(LocalDate.now());
		Time refundTime = Time.valueOf(LocalTime.now());

		Refund refund = new Refund();

		refund.setPaymentDetails(paymentDetails);
		refund.setRefundAmount(refundAmount);
		refund.setRefundDate(refundDate);
		refund.setRefundTime(refundTime);
		refund.setUser(user);
		refundRepo.save(refund);

		bookingRepo.delete(booking);
	}

	/**
	 * Calculates refund amount
	 * 
	 * @param currentDate   the Current Date
	 * @param departureDate the Departure Date
	 * @param price         the price
	 * @return the refund amount
	 */
	private double calculateRefundAmount(Date currentDate, Date departureDate, Date departureTime, int price) {

		long diffInMillies = Math.abs(currentDate.getTime() - departureDate.getTime());
		long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		System.out.println(diffInMillies + "   " + diff);

		if (diff >= 48) {
			return price * 0.9;
		}
		if (diff >= 24) {
			return price * 0.8;
		}
		if (diff > 2) {
			return price * 0.7;
		}
		if (diff > 1) {
			return price * 0.5;
		}
		return 0;
	}

	/**
	 * gets list of bookings for an user
	 * 
	 * @param username the username
	 * @return List of UserBookingDTO
	 */
	public List<UserBookingDto> getBookings(String username) {

		User user = userRepo.findByUsername(username);
		long userId = user.getUserId();
		List<Booking> bookingList = bookingRepo.findByUser(userId);
		List<UserBookingDto> bookings = new ArrayList<>();
		for (Booking booking : bookingList) {
			bookings.add(new UserBookingDto(booking));
		}
		return bookings;
	}

	/**
	 * gets list of refunds for an user
	 * 
	 * @param username the username
	 * @return List of RefundDTO
	 */
	public List<RefundDto> getRefundsList(String username) {
		User user = userRepo.findByUsername(username);
		List<Refund> refundsList = refundRepo.findByUser(user.getUserId());
		List<RefundDto> refunds = new ArrayList<>();
		for (Refund refund : refundsList) {
			RefundDto refundDto = new RefundDto(refund);
			refunds.add(refundDto);
		}
		return refunds;
	}

}
