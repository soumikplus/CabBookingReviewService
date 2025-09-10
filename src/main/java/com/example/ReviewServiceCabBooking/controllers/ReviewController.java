package com.example.ReviewServiceCabBooking.controllers;


import com.example.ReviewServiceCabBooking.Service.ReviewService;
import com.example.ReviewServiceCabBooking.model.Booking;
import com.example.ReviewServiceCabBooking.model.Review;
import com.example.ReviewServiceCabBooking.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final BookingRepository bookingRepository;
    public ReviewController(ReviewService reviewService,BookingRepository bookingRepository){
        this.reviewService = reviewService;
        this.bookingRepository = bookingRepository;
    }
    // create review
    @PostMapping
    public ResponseEntity<Review>publishReview(@RequestBody Review review){
        Booking booking = bookingRepository.findById(review.getBooking().getId())
                .orElseThrow(()-> new RuntimeException("Booking not found"));
        Review savedReview = reviewService.publishReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // get all review
    @GetMapping
    public ResponseEntity<List<Review>>getAllReviews(){
        List<Review>reviews = reviewService.findAllReviews();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    // get review by Id's
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId){
        Optional<Review> review = reviewService.findReviewById(reviewId);
        return review.isPresent()
                ? new ResponseEntity<>(review.get(),HttpStatus.OK)
                : new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
    }

    // update review
    @PutMapping("/{reviewId}")
    public ResponseEntity<?>updateReview(@PathVariable Long reviewId,@RequestBody Review updatedReview){
        try{
            Review review = reviewService.updateReview(reviewId,updatedReview);
            return new ResponseEntity<>(review,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }
    // delete review
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReviewById(reviewId);
        return deleted
                ? new ResponseEntity<>("Review deleted successfully", HttpStatus.OK)
                : new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }
}
