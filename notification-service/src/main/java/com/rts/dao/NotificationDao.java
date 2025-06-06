package com.rts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.model.Notification;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Integer> {
}
