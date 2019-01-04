package com.isi.project.service;

import com.isi.project.entities.Measurement;
import com.isi.project.entities.Notification;
import com.isi.project.entities.enums.MeasurementType;
import com.isi.project.entities.enums.NotificationType;
import com.isi.project.repository.MeasurementRepository;
import com.isi.project.repository.NotificationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;
    private MeasurementRepository measurementRepository;

    public NotificationService(NotificationRepository notificationRepository, MeasurementRepository measurementRepository) {
        this.notificationRepository = notificationRepository;
        this.measurementRepository = measurementRepository;
    }

    public ResponseEntity<List<Notification>> getNotifications() {
        Calendar calendar = Calendar.getInstance();
        Integer time = calendar.get(Calendar.HOUR_OF_DAY) * 360 + calendar.get(Calendar.MINUTE) * 6 + calendar.get(Calendar.SECOND) / 10;
        List<Notification> notifications = this.notificationRepository.findTop5ByTimeIsLessThanEqualOrderByTimeDesc(time);

        return new ResponseEntity<List<Notification>>(notifications, HttpStatus.OK);
    }

    public ResponseEntity<?> populatNotifications() {
        this.notificationRepository.deleteAll();
        List<Notification> notifications = new ArrayList<>();
        for (Measurement measurement : this.measurementRepository.findAll()) {
            Float minVal = 0f;
            Float maxVal = 0f;
            if (measurement.getType() == MeasurementType.PH) {
                minVal = 6.4f;
                maxVal = 8.6f;
            }

            if (measurement.getValue() < minVal) {
                String description = "Alert! " + measurement.getType().name() + " level low: " + measurement.getValue();
                notifications.add(new Notification(
                                measurement.getTime(),
                                measurement.getType(),
                                NotificationType.LOW,
                                measurement.getValue(),
                                description));

            } else if (measurement.getValue() > maxVal) {
                String description = "Alert! " + measurement.getType().name() + " level high: " + measurement.getValue();
                notifications.add(new Notification(
                        measurement.getTime(),
                        measurement.getType(),
                        NotificationType.HIGH,
                        measurement.getValue(),
                        description));
            }
        }

        this.notificationRepository.save(notifications);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
