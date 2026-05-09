package com.company.platform.analyticsservice.service;

import com.company.platform.analyticsservice.entity.AnalyticsEvent;
import com.company.platform.analyticsservice.model.UserCreatedEvent;
import com.company.platform.analyticsservice.repository.AnalyticsEventRepository;
import org.springframework.stereotype.Service;
import com.company.platform.analyticsservice.model.AnalyticsResponse;
import java.util.List;

import java.time.LocalDateTime;

@Service
public class AnalyticsEventService {

    private final AnalyticsEventRepository analyticsEventRepository;

    public AnalyticsEventService(AnalyticsEventRepository analyticsEventRepository) {
        this.analyticsEventRepository = analyticsEventRepository;
    }

    public void saveUserCreatedEvent(UserCreatedEvent event) {
        AnalyticsEvent analyticsEvent = new AnalyticsEvent();
        analyticsEvent.setUserId(event.getUserId());
        analyticsEvent.setName(event.getName());
        analyticsEvent.setEmail(event.getEmail());
        analyticsEvent.setEventType("USER_CREATED");
        analyticsEvent.setCreatedAt(LocalDateTime.now());

        analyticsEventRepository.save(analyticsEvent);
    }

    public List<AnalyticsResponse> getAllAnalyticsEvents() {
        return analyticsEventRepository.findAll()
                .stream()
                .map(event -> new AnalyticsResponse(
                        event.getId(),
                        event.getUserId(),
                        event.getName(),
                        event.getEmail(),
                        event.getEventType(),
                        event.getCreatedAt()
                ))
                .toList();
    }
}