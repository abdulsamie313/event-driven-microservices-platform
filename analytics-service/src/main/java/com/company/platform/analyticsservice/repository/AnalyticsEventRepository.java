package com.company.platform.analyticsservice.repository;

import com.company.platform.analyticsservice.entity.AnalyticsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsEventRepository extends JpaRepository<AnalyticsEvent, Long> {
}