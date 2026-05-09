package com.company.platform.analyticsservice.model;

import java.time.LocalDateTime;

public class AnalyticsResponse {

    private Long id;
    private Long userId;
    private String name;
    private String email;
    private String eventType;
    private LocalDateTime createdAt;

    public AnalyticsResponse(Long id, Long userId, String name,
                             String email, String eventType,
                             LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.eventType = eventType;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getEventType() { return eventType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}