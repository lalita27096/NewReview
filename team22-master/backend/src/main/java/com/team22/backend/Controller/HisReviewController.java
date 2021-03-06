package com.team22.backend.Controller;
import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class HisReviewController{
    @Autowired
    private HisReRepository hisReRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    

    public HisReviewController(HisReRepository hisReRepository,ReviewRepository reviewRepository) {
        this.hisReRepository = hisReRepository;
        this.reviewRepository = reviewRepository;
    }
    @GetMapping("/historyReview")
    public Collection<HistoryReview> historyReview() {
        return hisReRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    // @GetMapping("/History")
    // public Collection<Review> reviewuct() {
    //     return ReviewRepository.findAll().stream()
    //             filter((s) -> .equals(s.get()) && id.equals(s.getCustomer().getCustomerIDs()))
    //             .collect(Collectors.toList());
    // }
    
}