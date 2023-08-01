package com.rrs;

import java.sql.Time;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.Train;
import com.rrs.repositories.TrainRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TrainRepoTest {
	@Autowired
	private TrainRepo trainRepo;
	
	@Test
	public void addNewTrainTest() {
		Train train = Train.builder()
						.trainNo(14103)
						.trainName("Satabdi Express")
						.trainType("Express")
						.noOfSeats(500)
						.sourceStn("Howrah")
						.destinationStn("Ranchi")
						.departureTime(Time.valueOf("15:08:00"))
						.arrivalTime(Time.valueOf("03:26:00"))
						.a1Price(500)
						.a2Price(400)
						.a3Price(300)
						.slPrice(200)
						.genPrice(100)
						.build();
		trainRepo.save(train);
		Assertions.assertThat(train.getTrainNo()).isEqualTo(14103);
		
	}
	
	@Test
	public void scheduleTrainTest() {
		Train train = trainRepo.findById(12102L).get();
		train.setDepartureTime(Time.valueOf("15:00:00"));
		train.setArrivalTime(Time.valueOf("05:00:00"));
		Train recheduledTrain = trainRepo.save(train);
		Assertions.assertThat(recheduledTrain.getDepartureTime()).isEqualTo(Time.valueOf("15:00:00"));
		Assertions.assertThat(recheduledTrain.getArrivalTime()).isEqualTo(Time.valueOf("05:00:00"));
	}
	
	@Test
	public void getAllTrainsTest() {
		List<Train> train= trainRepo.findAll();
		Assertions.assertThat(train.size()).isGreaterThan(0);
	}
}
