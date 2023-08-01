package com.rrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rrs")
public class RailwayReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationSystemApplication.class, args);
	}
}
