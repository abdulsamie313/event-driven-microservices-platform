package com.company.platform.notificationservice.consumer;

import com.company.platform.notificationservice.model.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {

    @KafkaListener(topics = "user-created", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(UserCreatedEvent event) {
        System.out.println("Received user-created event:");
        System.out.println("Email: " + event.getEmail());

        if (event.getEmail().contains("fail")) {
            throw new RuntimeException("Simulated notification failure");
        }
    }
}