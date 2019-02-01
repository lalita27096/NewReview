package com.team22.backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Review")
public class Review {
    @Id
    @SequenceGenerator(name="review_seq",sequenceName="review_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="review_seq")
    @Column(name="Review_ID",unique = true, nullable = false)
     
    private @NonNull Long reviewId;
    private @NonNull String reviewIDs;
    private @NonNull String reviewComment;
    private @NonNull String reviewLevel;
    private @NonNull LocalDate reviewDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HistoryReviewId")
    private HistoryReview historyReview;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PmId")
    private PayMent payMent;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "customerId", insertable = true)
    private Customer customer;
 }