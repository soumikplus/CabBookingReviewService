package com.example.ReviewServiceCabBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReviewServiceCabBookingApplication {

	public static void main(String[] args) {
        SpringApplication.run(ReviewServiceCabBookingApplication.class, args);
	}

}
