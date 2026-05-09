package com.company.platform.analyticsservice.consumer;

import com.company.platform.analyticsservice.model.UserCreatedEvent;
import com.company.platform.analyticsservice.service.AnalyticsEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserAnalyticsConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(UserAnalyticsConsumer.class);

    private final AnalyticsEventService analyticsEventService;

    public UserAnalyticsConsumer(AnalyticsEventService analyticsEventService) {
        this.analyticsEventService = analyticsEventService;
    }

    @KafkaListener(
            topics = "user-created",
            groupId = "analytics-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(UserCreatedEvent event) {

        log.info("Analytics received user-created event for email: {}", event.getEmail());

        analyticsEventService.saveUserCreatedEvent(event);

        log.info("Analytics event saved for user ID: {}", event.getUserId());
    }
}