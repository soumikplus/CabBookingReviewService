package com.example.ReviewServiceCabBooking.Service;


import com.example.ReviewServiceCabBooking.model.Review;
import com.example.ReviewServiceCabBooking.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private  final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("**************");
        Review r = Review.builder()
                .content("Amazing Cab Quality")
                .rating(4.0).build();
        System.out.println(r);
        reviewRepository.save(r);

        List<Review> reviews  = reviewRepository.findAll();
        for(Review review : reviews){
            System.out.println(review.getContent());
        }
//        reviewRepository.deleteById(2L);
    }
    // create Review
    public Review createReview(String content,Double rating){
        Review review = Review.builder()
                .content(content)
                .rating(rating)
                .build();
        return reviewRepository.save(review);
    }

    // Get All review

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id){
        return reviewRepository.findById(id);
    }
}
