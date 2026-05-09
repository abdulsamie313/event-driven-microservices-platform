package com.company.platform.notificationservice.controller;

import com.company.platform.notificationservice.model.NotificationResponse;
import com.company.platform.notificationservice.service.NotificationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {

    private final NotificationLogService notificationLogService;

    public NotificationController(NotificationLogService notificationLogService) {
        this.notificationLogService = notificationLogService;
    }

    @GetMapping
    public List<NotificationResponse> getNotifications() {
        return notificationLogService.getAllNotifications();
    }
}