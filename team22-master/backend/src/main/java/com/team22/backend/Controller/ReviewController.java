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
import java.util.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PayMentRepository payMentRepository;
    @Autowired
    private ProductRepository productRepository;

    public ReviewController(ReviewRepository reviewRepository,
                            CustomerRepository customerRepository,
                            PayMentRepository payMentRepository,
                            ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
        this.payMentRepository = payMentRepository;
        this.productRepository = productRepository;
    }
    @GetMapping("/review")
    public Collection<Review> review() {
        return reviewRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/PayMent")
    public Collection<PayMent> payMent() {
       return payMentRepository.findAll().stream()
               .filter(this::isPayMent)
               .collect(Collectors.toList());
    }
    private boolean isPayMent(PayMent PayMent){

       return PayMent.getStatusPay().equals("paid");
    }

    @PostMapping("/Rev/{typePay}/{statusPay}/{customerIDs}/{customerName}/{reviewDate}/{reviewLevel}/{reviewComment}")
        public Review newRev(@PathVariable String typePay,
                            @PathVariable String statusPay,
                            @PathVariable String  customerIDs,
                            @PathVariable String customerName,
                            @PathVariable String reviewDate,
                            @PathVariable String reviewComment){
            Review newReview = new Review();
            PayMent payMent = payMentRepository.findByTypePay(typePay);
            PayMent payMent1 = payMentRepository.findByStatusPay(statusPay);
            Customer customer = customerRepository.findByCustomerIDs(customerIDs);
            Customer customer1 = customerRepository.findByCustomerName(customerName);
            
            String RDate1 = reviewDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate date = LocalDate.parse(RDate1,formatter);
            newReview.setPayMent(payMent);
            newReview.setCustomer(customer);
            newReview.setReviewDate(date);
            System.out.println(date);
    
            return reviewRepository.save(newReview); 
        }

}