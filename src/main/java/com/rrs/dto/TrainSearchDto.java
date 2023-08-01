package com.rrs.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** DTO to store train search parameters*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainSearchDto {
	
	private String fromStn;
	private String toStn;
	private Date departureDate;
	private String trainType;

}
