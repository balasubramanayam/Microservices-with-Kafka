package com.rts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.model.Notification;
import com.rts.service.NotificationService;

@RestController
@RequestMapping("/api/notifications/")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;

	@GetMapping("/list")
	public List<Notification> getAll(){
		return notificationService.getAll();
		
	}
}
