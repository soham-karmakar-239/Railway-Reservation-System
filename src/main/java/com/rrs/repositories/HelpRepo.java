package com.rrs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrs.dto.HelpDto;
import com.rrs.models.Help;

/** The Help Repository*/

@Repository
public interface HelpRepo extends JpaRepository<Help, Long> {

	/** gets all tickets raised by an user*/
	@Query("SELECT help FROM Help AS help WHERE help.user.userId=:userId ORDER BY help.dateCreated DESC")
	List<Help> findByUserId(@Param(value = "userId") long userId);

	/** gets all unresolved tickets*/
	@Query("SELECT help FROM Help AS help WHERE help.resolution=:resolution ORDER BY help.dateCreated")
	List<HelpDto> findUnresolvedTickets(@Param(value="resolution")String resolution);

}
