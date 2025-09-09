package com.example.ReviewServiceCabBooking.Service;
import com.example.ReviewServiceCabBooking.model.Booking;
import com.example.ReviewServiceCabBooking.model.Driver;
import com.example.ReviewServiceCabBooking.model.Review;
import com.example.ReviewServiceCabBooking.projection.DriverView;
import com.example.ReviewServiceCabBooking.repository.BookingRepository;
import com.example.ReviewServiceCabBooking.repository.DriverRepository;
import com.example.ReviewServiceCabBooking.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private  final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository){
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("**************");
//        Review r = Review.builder()
//                .content("Amazing Cab Quality")
//                .rating(4.0)
//                .build();
//        System.out.println("Review : "+r);
//
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();
//        bookingRepository.save(b);
//        System.out.println("Booking : "+b);


//        Optional<Booking> b = bookingRepository.findById(2L);
//        if(b.isPresent()){
//            bookingRepository.delete(b.get());
//        }

//        reviewRepository.deleteById(2L);
//
//        Driver d1 = Driver.builder()
//                .name("Soumajit")
//                .licenseNumber("DL89374")
//                .build();
//
//
//        driverRepository.save(d1);
//        driverRepository.save(d2);

//        System.out.println("Driver inserted !");
//        driverRepository.findAll().forEach(
//                driver -> System.out.println(driver.getName() + " - " + driver.getLicenseNumber())
//        );
//
//        raw sql (Native query)
//        Optional<Driver> d = driverRepository.rawFindByIdAndLicenseNumber(1L,"DL89374");
//        Derived Query
          Optional<Driver>d = driverRepository.findByIdAndLicenseNumber(1L,"DL89374");
          if(d.isPresent()){
              Driver driver = d.get();
              System.out.println("Driver : "+ driver.getName()+ " | " + driver.getLicenseNumber());
          }
          else{
              System.out.println("No driver found!");
          }
        DriverView dView = driverRepository.findDriverInfoByIdNative(2L);
        System.out.println(dView.getName() + " | " + dView.getLicenseNumber());
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
