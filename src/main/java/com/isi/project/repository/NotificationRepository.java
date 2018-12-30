package com.isi.project.repository;

import com.isi.project.entities.Notification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Measurement", path = "measurement")
public interface NotificationRepository  extends CrudRepository<Notification, Long> {
    @Transactional
    @Modifying
    void deleteAll();

    List<Notification> findAllByTimeIsLessThanEqualOrderByTimeDesc(@Param("time") Integer time);
}