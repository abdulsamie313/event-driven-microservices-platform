package com.company.platform.notificationservice.consumer;

import com.company.platform.notificationservice.model.UserCreatedEvent;
import com.company.platform.notificationservice.service.NotificationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(UserEventConsumer.class);

    private final NotificationLogService notificationLogService;

    public UserEventConsumer(NotificationLogService notificationLogService) {
        this.notificationLogService = notificationLogService;
    }

    @KafkaListener(
            topics = "user-created",
            groupId = "notification-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(UserCreatedEvent event) {

        log.info("Received user-created event for email: {}", event.getEmail());

        if (event.getEmail().contains("fail")) {
            throw new RuntimeException("Simulated notification failure");
        }

        notificationLogService.saveNotificationLog(event);

        log.info("Notification log saved for user ID: {}", event.getUserId());
    }
}