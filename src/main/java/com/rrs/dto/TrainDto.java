package com.rrs.dto;

import java.sql.Time;

import com.rrs.models.Train;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** DTO to store train details*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainDto {

	private long trainNo;
	private String trainName;
	private String trainType;
	private int noOfSeats;
	private int a1Price;
	private int a2Price;
	private int a3Price;
	private int slPrice;
	private int genPrice;
	private String sourceStn;
	private Time departureTime;
	private String destinationStn;
	private Time arrivalTime;
	
	/** Instantiates and initializes TrainDto object from Train object*/
	public TrainDto(Train train) {
		this.trainNo=train.getTrainNo();
		this.trainName=train.getTrainName();
		this.trainType=train.getTrainType();
		this.noOfSeats=train.getNoOfSeats();
		this.a1Price=train.getA1Price();
		this.a2Price=train.getA2Price();
		this.a3Price=train.getA3Price();
		this.slPrice=train.getSlPrice();
		this.genPrice=train.getGenPrice();
		this.sourceStn=train.getSourceStn();
		this.departureTime=train.getDepartureTime();
		this.destinationStn=train.getDestinationStn();
		this.arrivalTime=train.getArrivalTime();
	}
	
}
