package com.isi.project.entities;

import com.isi.project.entities.enums.MeasurementType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private MeasurementType type;
    private Integer time;
    private Float value;

    public Measurement() {
    }

    public Measurement(MeasurementType type, Integer time, Float value) {
        this.type = type;
        this.time = time;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeasurementType getType() {
        return type;
    }

    public void setType(MeasurementType type) {
        this.type = type;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
