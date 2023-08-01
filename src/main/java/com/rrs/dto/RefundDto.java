package com.rrs.dto;

import java.sql.Date;

import com.rrs.models.Refund;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** DTO to store refund details*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RefundDto {

	private long refundId;
	private double refundAmount;
	private String cardNo;
	private String cardHolderName;
	private Date refundDate;

	/** Instantiates and initializes RefundDto object from Refund object*/
	public RefundDto(Refund refund) {
		this.refundId = refund.getRefundId();
		this.refundAmount = refund.getRefundAmount();
		this.cardNo = refund.getPaymentDetails().getCardNo();
		this.cardHolderName = refund.getPaymentDetails().getCardHolderName();
		this.refundDate = refund.getRefundDate();
	}
}
