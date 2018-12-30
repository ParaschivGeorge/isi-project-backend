package com.isi.project.controller;

import com.isi.project.entities.Measurement;
import com.isi.project.entities.enums.MeasurementType;
import com.isi.project.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeasurementController {
    private MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping(path = "/measurement/populate")
    public ResponseEntity<?> populateMeasurements(@RequestParam() MeasurementType type) {
        return this.measurementService.populateMeasurements(type);
    }

    @GetMapping(path = "/measurement/getByType")
    public ResponseEntity<List<Measurement>> getMeasurementsByType(@RequestParam() MeasurementType type) {
        return this.measurementService.getMeasurementsByType(type);
    }
}
