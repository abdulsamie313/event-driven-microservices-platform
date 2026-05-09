package com.company.platform.notificationservice.model;

import java.time.LocalDateTime;

public class NotificationResponse {

    private Long id;
    private Long userId;
    private String email;
    private String message;
    private LocalDateTime createdAt;

    public NotificationResponse(Long id, Long userId, String email,
                                String message, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}