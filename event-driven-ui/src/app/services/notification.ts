import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface NotificationResponse {
  id: number;
  userId: number;
  email: string;
  message: string;
  createdAt: string;
}

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private apiUrl = 'http://localhost:8082';

  constructor(private http: HttpClient) {}

  getNotifications(): Observable<NotificationResponse[]> {
    return this.http.get<NotificationResponse[]>(
      `${this.apiUrl}/notifications`
    );
  }
}