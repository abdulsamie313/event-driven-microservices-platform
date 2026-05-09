import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  NotificationService,
  NotificationResponse
} from '../../services/notification';

@Component({
  selector: 'app-notifications',
  imports: [CommonModule],
  templateUrl: './notifications.html',
  styleUrl: './notifications.css',
})
export class Notifications implements OnInit {

  notifications: NotificationResponse[] = [];

  constructor(
    private notificationService: NotificationService
  ) {}

  ngOnInit(): void {
    this.loadNotifications();
  }

  loadNotifications(): void {
    this.notificationService.getNotifications()
      .subscribe({
        next: (data) => {
          this.notifications = data;
        },
        error: (error) => {
          console.error('Error fetching notifications', error);
        }
      });
  }
}