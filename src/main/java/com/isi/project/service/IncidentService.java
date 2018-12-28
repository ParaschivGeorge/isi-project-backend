package com.isi.project.service;

import com.isi.project.entities.Incident;
import com.isi.project.entities.User;
import com.isi.project.entities.enums.IncidentStatus;
import com.isi.project.repository.IncidentRepository;
import com.isi.project.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class IncidentService {

    private IncidentRepository incidentRepository;
    private UserRepository userRepository;

    public IncidentService(IncidentRepository incidentRepository, UserRepository userRepository) {
        this.incidentRepository = incidentRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> createIncident(String email, String description) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }

        Incident incident = new Incident();
        incident.setUser(user);
        incident.setDescription(description);
        incident.setStatus(IncidentStatus.WAITING);
        incident.setTime(new Date());

        incident = incidentRepository.save(incident);

        return new ResponseEntity<>(incident.getId(), HttpStatus.OK);
    }
}
