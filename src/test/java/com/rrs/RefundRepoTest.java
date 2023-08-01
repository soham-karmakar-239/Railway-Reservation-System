package com.rrs;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rrs.models.Refund;
import com.rrs.repositories.RefundRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RefundRepoTest {

		@Autowired
		RefundRepo refundRepo;
		
		@Test
		public void getAllRefundsTest() {
			List<Refund> refund = refundRepo.findAll();
			Assertions.assertThat(refund.size()).isGreaterThan(0);
		}
}
