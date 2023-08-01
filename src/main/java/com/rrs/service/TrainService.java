package com.rrs.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.dto.TrainDto;
import com.rrs.dto.TrainSearchDto;
import com.rrs.models.Train;
import com.rrs.repositories.TrainRepo;

/** The Tearch Service class */
@Service
public class TrainService {

	/** the train Repository */
	@Autowired
	private TrainRepo trainRepo;

	/**
	 * gets a list with search results for a train number
	 * 
	 * @param trainNo the train number
	 * @return List of trains
	 */
	public List<Train> searchTrainById(long trainNo) {
		List<Train> trains = new ArrayList<>();
		try {
			Train trainDetails = getTrainDetails(trainNo);
			trains.add(trainDetails);
		} catch (NoSuchElementException ex) {
		}
		return trains;
	}

	/**
	 * gets list of trains based on search parameters
	 * 
	 * @param trainSearchDto the search parameters
	 * @return List of TrainDTO
	 */
	public List<TrainDto> searchTrains(TrainSearchDto trainSearchDto) {
		String fromStn = trainSearchDto.getFromStn();
		String toStn = trainSearchDto.getToStn();
		String trainType = trainSearchDto.getTrainType();
		List<Train> searchTrains = trainRepo.searchTrains(fromStn.toUpperCase(), toStn.toUpperCase(), trainType);
		List<TrainDto> trains = new ArrayList<>();
		for (Train train : searchTrains) {
			trains.add(new TrainDto(train));
		}
		return trains;
	}

	/** gets Train details for a train number */
	public Train getTrainDetails(long trainNo) {
		return trainRepo.findById(trainNo).get();
	}

	/** gets all trains */
	public List<Train> getAllTrains() {
		return trainRepo.findAll();
	}

	/**
	 * adds a new train
	 * 
	 * @param trainDto          the Train DTO
	 * @param departureTimeUtil the departure time
	 * @param arrivalTimeUtil   the arrival time
	 */
	public void addTrain(TrainDto trainDto, Date departureTimeUtil, Date arrivalTimeUtil) {
		Time departureTime = new Time(departureTimeUtil.getTime());
		Time arrivalTime = new Time(arrivalTimeUtil.getTime());
		trainDto.setDepartureTime(departureTime);
		trainDto.setArrivalTime(arrivalTime);
		trainRepo.save(new Train(trainDto));
	}

	/** gets TrainDto based on a train number */
	public TrainDto getTrainDto(long trainNo) {
		TrainDto trainDto = new TrainDto(trainRepo.findById(trainNo).get());
		return trainDto;
	}

	/**
	 * gets the price for a train and a seat class
	 * 
	 * @param trainNo   the train number
	 * @param seatClass the seat class
	 */
	public int getPrice(long trainNo, String seatClass) {
		TrainDto trainDto = getTrainDto(trainNo);
		if (seatClass.equalsIgnoreCase("1a")) {
			return trainDto.getA1Price();
		}
		if (seatClass.equalsIgnoreCase("2a")) {
			return trainDto.getA2Price();
		}
		if (seatClass.equalsIgnoreCase("3a")) {
			return trainDto.getA3Price();
		}
		if (seatClass.equalsIgnoreCase("sl")) {
			return trainDto.getSlPrice();
		}
		return trainDto.getGenPrice();
	}

	/**
	 * verifies if the train number is unique
	 * 
	 * @param trainNo the train number
	 * @return if the train number is unique
	 */
	public boolean verifyUniqueTrainNo(long trainNo) {
		Train train = trainRepo.findById(trainNo).get();
		if (train == null) {
			return true;
		}
		return false;
	}

}
