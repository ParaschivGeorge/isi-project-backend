package com.isi.project.controller;


import com.isi.project.entities.Measurement;
import com.isi.project.entities.Notification;
import com.isi.project.entities.enums.MeasurementType;
import com.isi.project.service.MeasurementService;
import com.isi.project.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(path = "/notification/populate")
    public ResponseEntity<?> populateNotifications() {
        return this.notificationService.populatNotifications();
    }

    @GetMapping(path = "/notification/get")
    public ResponseEntity<List<Notification>> getNotifications() {
        return this.notificationService.getNotifications();
    }
}
