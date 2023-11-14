package com.fornax.petware.Repository.GeofencesRepo;

import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeofenceRepo extends JpaRepository<Geofences, Long>{
    @Query("SELECT G from Geofences as G where G.user.id = :userId ")
    List<Geofences> findGeofencesByUserId(@Param("userId") Long userId);
}
