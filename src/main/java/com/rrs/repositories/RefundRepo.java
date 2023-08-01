package com.rrs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrs.models.Refund;

/** The Refund Repository*/

@Repository
public interface RefundRepo extends JpaRepository<Refund, Long> {

	/** gets all refunds for an user*/
	@Query("SELECT refund FROM Refund AS refund WHERE refund.user.userId = :userId"
			+ " ORDER BY refund.refundDate DESC, refund.refundTime DESC")
	public List<Refund> findByUser(@Param("userId") long userId);
}
