package com.isi.project.repository;

import com.isi.project.entities.Incident;
import com.isi.project.entities.enums.IncidentStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "Incident", path = "incident")
public interface IncidentRepository extends CrudRepository<Incident, Long> {
    List<Incident> findAllByStatusOrderByTimeDesc(@Param("status") IncidentStatus status);
    List<Incident> findAllByOrderByTimeDesc();

    @Transactional
    @Modifying
    @Query("update Incident incident set incident.status = :status where incident.id = :id")
    int setStatus(@Param("status") IncidentStatus status, @Param("id") Long id);
}