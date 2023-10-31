package com.fornax.petware.Controller.GeofenceContro;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Repository.GeofencesRepo.GeofenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GeofenceController {

    @Autowired
    GeofenceRepo geofenceRepo;


    @GetMapping("Geofences")
    public List<Geofences> getAllGeofences() {
        return geofenceRepo.findAll();
    }

    @GetMapping("geofences/{id}")
    public Optional<Geofences> getGeofence(@PathVariable(value = "id") Long id) {
        return geofenceRepo.findById(id);
    }

    @PostMapping("geofences")
    public Geofences addGeofence(@RequestBody Geofences geofences) {
        return geofenceRepo.save(geofences);
    }


    @DeleteMapping("/geofence/{id}")
    public ResponseEntity<?> deleteGeofence(@PathVariable(value = "id") Long id) {
        geofenceRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("geofences/{id}")
    public ResponseEntity<Geofences> updateGeofences(@PathVariable(value = "id") Long id,
                                           @RequestBody Geofences geofenceUpdate) {

        Optional<Geofences> geofences = geofenceRepo.findById(id);

        geofences.get().setName(geofenceUpdate.getName());
        geofences.get().setCoordinate(geofenceUpdate.getCoordinate());
        Geofences updatedGeofences = geofenceRepo.save(geofences.get());
        return ResponseEntity.ok(updatedGeofences);
    }
}

