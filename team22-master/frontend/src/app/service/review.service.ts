import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  constructor(private http: HttpClient) {
  }

  getPayMentReview(): Observable<any> {
    return this.http.get('//localhost:8080/PayMentReview');
  }
  getCustomer(): Observable<any> {
    return this.http.get('//localhost:8080/customer');
  }
  getHistoryReview(): Observable<any> {
    return this.http.get('//localhost:8080/historyReview');
  }
}
