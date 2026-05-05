package com.company.platform.analyticsservice.consumer;

import com.company.platform.analyticsservice.model.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserAnalyticsConsumer {

    @KafkaListener(topics = "user-created", groupId = "analytics-group")
    public void consume(UserCreatedEvent event) {
        System.out.println("Analytics event received:");
        System.out.println("New user registered: " + event.getEmail());
    }
}