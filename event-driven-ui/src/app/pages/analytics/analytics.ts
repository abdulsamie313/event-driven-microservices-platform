import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  AnalyticsService,
  AnalyticsResponse
} from '../../services/analytics';

@Component({
  selector: 'app-analytics',
  imports: [CommonModule],
  templateUrl: './analytics.html',
  styleUrl: './analytics.css',
})
export class Analytics implements OnInit {

  analyticsEvents: AnalyticsResponse[] = [];

  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit(): void {
    this.loadAnalyticsEvents();
  }

  loadAnalyticsEvents(): void {
    this.analyticsService.getAnalyticsEvents()
      .subscribe({
        next: (data) => {
          this.analyticsEvents = data;
        },
        error: (error) => {
          console.error('Error fetching analytics events', error);
        }
      });
  }
}