package com.rts.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rts.dao.NotificationDao;
import com.rts.model.Notification;
import com.rts.model.Order;

@Service  
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consumeOrder(Order order) {
        System.out.println("Received order: " + order);

        // Create notification message
        String message = "Notification for order ID: " + order.cartId();
        saveNotification(order.cartId(), message);

        // Send notification (e.g., email, SMS)
        sendNotification(order);
    }

    private void saveNotification(Integer orderId, String message) {
        Notification notification = new Notification();
        notification.setOrderId(orderId);
        notification.setMessage(message);
        notification.setCreatedAt(new Date());

        notificationDao.save(notification);
        System.out.println("Notification saved to DB: " + notification);
    }

    private void sendNotification(Order order) {
        System.out.println("Sending notification for order ID: " + order.cartId());
    }
    
    
    public List<Notification> getAll(){
    	return notificationDao.findAll();
    }
}
