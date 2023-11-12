package com.fornax.petware.Repository.CoordinateRepo;

import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {


    // Obtener coordenadas de un Geofence
    @Query("SELECT c.orderNum, c.lat, c.lng, c.id FROM Coordinate c WHERE c.coordinates.id = :geofenceId")
    List<String[]> findByGeofenceId(Long geofenceId);
}
