package com.fornax.petware.Repository.GeofencesRepo;

import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeofenceRepo extends JpaRepository<Geofences, Long>{

}
