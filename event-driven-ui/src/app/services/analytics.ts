import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface AnalyticsResponse {
  id: number;
  userId: number;
  name: string;
  email: string;
  eventType: string;
  createdAt: string;
}

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {

  private apiUrl = 'http://localhost:8083';

  constructor(private http: HttpClient) {}

  getAnalyticsEvents(): Observable<AnalyticsResponse[]> {
    return this.http.get<AnalyticsResponse[]>(
      `${this.apiUrl}/analytics`
    );
  }
}