package com.company.platform.analyticsservice.controller;

import com.company.platform.analyticsservice.model.AnalyticsResponse;
import com.company.platform.analyticsservice.service.AnalyticsEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@CrossOrigin(origins = "http://localhost:4200")
public class AnalyticsController {

    private final AnalyticsEventService analyticsEventService;

    public AnalyticsController(AnalyticsEventService analyticsEventService) {
        this.analyticsEventService = analyticsEventService;
    }

    @GetMapping
    public List<AnalyticsResponse> getAnalyticsEvents() {
        return analyticsEventService.getAllAnalyticsEvents();
    }
}