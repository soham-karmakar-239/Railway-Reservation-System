package com.rrs.models;

import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.rrs.dto.TrainDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Train entity*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Train {

	/** the train number */
	@Id
	private long trainNo;

	/** the train name */
	private String trainName;

	/** the train type */
	private String trainType;

	/** the number of seats */
	private int noOfSeats;

	/** the price of 1tier AC seat */
	private int a1Price;

	/** the price of 2tier AC seat */
	private int a2Price;

	/** the price of 3tier AC seat */
	private int a3Price;

	/** the price of Sleeper seat */
	private int slPrice;

	/** the price of General seat */
	private int genPrice;

	/** the source station */
	private String sourceStn;

	/** the departure time */
	private Time departureTime;

	/** the destination station */
	private String destinationStn;

	/** the arrival time */
	private Time arrivalTime;

	/** the bookings */
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
	private Set<Booking> bookings;

	/** Instantiates and initializes new Train object from TrainDto object */
	public Train(TrainDto trainDto) {
		this.trainNo = trainDto.getTrainNo();
		this.trainName = trainDto.getTrainName();
		this.trainType = trainDto.getTrainType();
		this.noOfSeats = trainDto.getNoOfSeats();
		this.a1Price = trainDto.getA1Price();
		this.a2Price = trainDto.getA2Price();
		this.a3Price = trainDto.getA3Price();
		this.slPrice = trainDto.getSlPrice();
		this.genPrice = trainDto.getGenPrice();
		this.sourceStn = trainDto.getSourceStn();
		this.departureTime = trainDto.getDepartureTime();
		this.destinationStn = trainDto.getDestinationStn();
		this.arrivalTime = trainDto.getArrivalTime();
	}

}
