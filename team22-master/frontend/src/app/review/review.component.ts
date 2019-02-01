import { Component, OnInit, ViewChild } from '@angular/core';
import { ReviewService } from '../service/review.service';
import {MatSort} from '@angular/material';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  displayedColumns1: string[] = ['customerIDs', 'customerName', 'reviewLevel','commentReview'];

  Reviews: Array<any>;
  reviewLevel: Array<any>;
  reviewDate: Array<any>;
  commentReview: Array<any>;

  Customers: Array<any>;
  customerIDs: Array<any>;
  customerName: Array<any>;

  PayMents: Array<any>;
  statusPay: Array<any>;
  HistoryReviews: Array<any>;



  @ViewChild(MatSort)
  sort: MatSort;
  constructor(private reviewService: ReviewService, private httpClient: HttpClient, private router:
  Router) { }

  ngOnInit() {
    // this.reviewService.getReview().subscribe(data => {
    //   this.Reviews = data;
    //   console.log(this.Reviews);
    // });
    this.reviewService.getPayMentReview().subscribe(data => {
      this.PayMents = data;
      console.log(this.PayMents);
    });
    this.reviewService.getCustomer().subscribe(data => {
      this.Customers = data;
      console.log(this.Customers);
    });
    this.reviewService.getHistoryReview().subscribe(data => {
      this.HistoryReviews = data;
      console.log(this.HistoryReviews);
    });
  }

}

