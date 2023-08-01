package com.rrs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrs.models.Booking;

/** The Booking Repository*/

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
	
	/** Gets all bookings for an user*/
	@Query("SELECT booking FROM Booking AS booking WHERE booking.user.userId = :userId"
			+ " ORDER BY booking.bookingDate DESC, booking.bookingTime DESC")
	public List<Booking> findByUser(@Param("userId") long userId);
	
	/** Finds booking by pnr number*/
	public Optional<Booking> findByPnr(long pnr);

}
