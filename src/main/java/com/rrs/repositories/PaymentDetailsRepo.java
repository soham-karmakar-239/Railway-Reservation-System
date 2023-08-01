package com.rrs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrs.models.PaymentDetails;

/** The PaymentDetails Repository*/

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Long> {

}
