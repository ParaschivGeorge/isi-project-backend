package com.isi.project.entities;

import com.isi.project.entities.enums.MeasurementType;
import com.isi.project.entities.enums.NotificationType;

import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer time;
    private MeasurementType measurementType;
    private NotificationType type;
    private Float value;
    private String description;

    public Notification() {
    }

    public Notification(Integer time, MeasurementType measurementType, NotificationType type, Float value, String description) {
        this.time = time;
        this.measurementType = measurementType;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
