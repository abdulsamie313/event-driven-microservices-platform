package com.company.platform.analyticsservice.consumer;

import com.company.platform.analyticsservice.model.UserCreatedEvent;
import com.company.platform.analyticsservice.service.AnalyticsEventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserAnalyticsConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(UserAnalyticsConsumer.class);

    private final AnalyticsEventService analyticsEventService;
    private final ObjectMapper objectMapper;

    public UserAnalyticsConsumer(
            AnalyticsEventService analyticsEventService,
            ObjectMapper objectMapper
    ) {
        this.analyticsEventService = analyticsEventService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(
            topics = "user-created",
            groupId = "analytics-group"
    )
    public void consume(String message) {
        try {
            log.info("Analytics received raw event: {}", message);

            UserCreatedEvent event =
                    objectMapper.readValue(message, UserCreatedEvent.class);

            analyticsEventService.saveUserCreatedEvent(event);

            log.info("Analytics event saved for user ID: {}", event.getUserId());

        } catch (Exception e) {
            log.error("Failed to process analytics event: {}", message, e);
        }
    }
}