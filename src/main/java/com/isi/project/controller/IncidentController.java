package com.isi.project.controller;

import com.isi.project.service.IncidentService;
import com.isi.project.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IncidentController {

    private IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping(path = "/incident/create")
    public ResponseEntity<?> createIncident(@RequestParam() String email, @RequestParam() String description) {
        return this.incidentService.createIncident(email, description);
    }
}
