package com.isi.project.service;

import com.isi.project.entities.Measurement;
import com.isi.project.entities.enums.MeasurementType;
import com.isi.project.repository.MeasurementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Service
public class MeasurementService {

    private MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public ResponseEntity<?> populateMeasurements(MeasurementType type) {
        this.measurementRepository.deleteAllByType(type);
        if (type == MeasurementType.PH) {
            this.populatePH();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void populatePH() {
        Integer time = 0;
        Random rand = new Random();
        List<Measurement> measurements = new ArrayList<>();

        while (time < 8640) {
            double value = rand.nextFloat() * (8.7 - 6.3) + 6.3;
            measurements.add(new Measurement(MeasurementType.PH, time, (float) value));
            time++;
        }

        this.measurementRepository.save(measurements);
    }

    public ResponseEntity<List<Measurement>> getMeasurementsByType(MeasurementType type) {
        Calendar calendar = Calendar.getInstance();
        Integer time = calendar.get(Calendar.HOUR_OF_DAY) * 360 + calendar.get(Calendar.MINUTE) * 6 + calendar.get(Calendar.SECOND) / 10;
        List<Measurement> measurements = this.measurementRepository.findAllByTypeAndTimeIsLessThanEqualOrderByTimeAsc(type, time);

        return new ResponseEntity<List<Measurement>>(measurements, HttpStatus.OK);
    }
}
