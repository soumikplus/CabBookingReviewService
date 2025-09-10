package com.example.ReviewServiceCabBooking.adapters;

import com.example.ReviewServiceCabBooking.dtos.CreateReviewDto;
import com.example.ReviewServiceCabBooking.model.Booking;
import com.example.ReviewServiceCabBooking.model.Review;
import com.example.ReviewServiceCabBooking.repository.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterimpl implements  CreateReviewDtoToReviewAdapter{
    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterimpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto){
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value->Review.builder()
//                .rating(createReviewDto.getRating())
                .booking(value)
//                .content(createReviewDto.getContent())
                .build())
                .orElse(null);
    }
}
