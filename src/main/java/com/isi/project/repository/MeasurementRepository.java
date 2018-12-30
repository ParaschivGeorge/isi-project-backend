package com.isi.project.repository;

import com.isi.project.entities.Measurement;
import com.isi.project.entities.enums.MeasurementType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Measurement", path = "measurement")
public interface MeasurementRepository  extends CrudRepository<Measurement, Long> {
    @Transactional
    @Modifying
    void deleteAllByType(@Param("type") MeasurementType type);

    List<Measurement> findAllByTypeAndTimeIsLessThanEqualOrderByTimeAsc(@Param("type") MeasurementType type, @Param("time") Integer time);
}
