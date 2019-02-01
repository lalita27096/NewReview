package com.team22.backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="HistoryReview")
public class HistoryReview {
    @Id
    @SequenceGenerator(name="historyReview_seq",sequenceName="historyReview_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historyReview_seq")
    @Column(name="HistoryReview_ID",unique = true, nullable = false)
     
    private @NonNull Long historyReviewId;
  
}