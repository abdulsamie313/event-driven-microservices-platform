package com.company.platform.notificationservice.service;

import com.company.platform.notificationservice.entity.NotificationLog;
import com.company.platform.notificationservice.model.NotificationResponse;
import com.company.platform.notificationservice.model.UserCreatedEvent;
import com.company.platform.notificationservice.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationLogService {

    private final NotificationLogRepository notificationLogRepository;

    public NotificationLogService(NotificationLogRepository notificationLogRepository) {
        this.notificationLogRepository = notificationLogRepository;
    }

    public void saveNotificationLog(UserCreatedEvent event) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setUserId(event.getUserId());
        notificationLog.setEmail(event.getEmail());
        notificationLog.setMessage("User created successfully");
        notificationLog.setCreatedAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);
    }

    public List<NotificationResponse> getAllNotifications() {

        return notificationLogRepository.findAll()
                .stream()
                .map(log -> new NotificationResponse(
                        log.getId(),
                        log.getUserId(),
                        log.getEmail(),
                        log.getMessage(),
                        log.getCreatedAt()
                ))
                .toList();
    }
}