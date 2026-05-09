package com.company.platform.notificationservice.repository;

import com.company.platform.notificationservice.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository
        extends JpaRepository<NotificationLog, Long> {
}