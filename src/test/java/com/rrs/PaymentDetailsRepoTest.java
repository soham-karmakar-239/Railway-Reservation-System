package com.rrs;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.PaymentDetails;
import com.rrs.repositories.PaymentDetailsRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PaymentDetailsRepoTest {
	
	@Autowired
	private PaymentDetailsRepo paymentRepo;
	
	@Test 
	public void newPaymentTest(){
		PaymentDetails payment = PaymentDetails.builder()
											   .paymentId(69L)
											   .cardHolderName("Soumyanetra")
											   .cardNo("1234567890237854")
											   .cvv(456)
											   .expiryYear(2025)
											   .expiryMonth(05)
											   .build();
		paymentRepo.save(payment);
		Assertions.assertThat(payment.getPaymentId()).isEqualTo(69);
	}
	
	@Test
	public void getAllPaymentDetailsTest() {
		List<PaymentDetails> paymentDetails = paymentRepo.findAll();
		Assertions.assertThat(paymentDetails.size()).isGreaterThan(0);
	}
}
