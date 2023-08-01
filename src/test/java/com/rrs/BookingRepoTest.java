package com.rrs;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.Booking;
import com.rrs.models.PaymentDetails;
import com.rrs.models.Train;
import com.rrs.models.User;
import com.rrs.repositories.BookingRepo;
import com.rrs.repositories.PaymentDetailsRepo;
import com.rrs.repositories.TrainRepo;
import com.rrs.repositories.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class BookingRepoTest {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TrainRepo trainRepo;
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private PaymentDetailsRepo paymentRepo;
	
	@Test
	public void bookTicketTest() {
		User user = userRepo.findById(1L).get();
		Train train = trainRepo.findById(12102L).get();
		PaymentDetails paymentDetails = paymentRepo.findById(21L).get();
		
		Booking booking = Booking.builder()
								 .pnr(69)
								 .bookingDate(Date.valueOf("2022-05-20"))
								 .bookingTime(Time.valueOf("12:35:00"))
								 .seatClass("A1")
								 .train(train)
								 .paymentDetails(paymentDetails)
								 .user(user)
								 .price(500)
								 .build();
		bookingRepo.save(booking);
		Assertions.assertThat(booking.getPnr()).isEqualTo(69);
	}
	
	@Test
	public void getAllTicketsTest() {
		List<Booking> booking = bookingRepo.findAll();
		Assertions.assertThat(booking.size()).isGreaterThan(0);
	}
	
	@Test
	public void cancelTicketTest() {
		Booking book = null;
		Booking booking = bookingRepo.findById(24L).get();
		bookingRepo.delete(booking);
		Optional<Booking> bookList = bookingRepo.findByPnr(24L);
		if(bookList.isPresent()) 
			book = bookList.get();
		
		Assertions.assertThat(book).isNull();
		
	}
}
