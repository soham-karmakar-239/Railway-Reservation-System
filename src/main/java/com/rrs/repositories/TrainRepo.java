package com.rrs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrs.models.Train;

/** The Train Repository*/
@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {

	/** gets all trains according to search parameters*/
	@Query("FROM Train WHERE upper(sourceStn)=:fromStn AND upper(destinationStn)=:toStn"
			+ " AND trainType=:trainType ORDER BY departureTime")
	List<Train> searchTrains(@Param("fromStn") String fromStn, @Param("toStn") String toStn,
			@Param("trainType") String trainType);

}
