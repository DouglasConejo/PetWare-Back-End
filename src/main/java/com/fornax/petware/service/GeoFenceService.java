package com.fornax.petware.service;


import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GeoFenceService {
    private List<Geofences> geofenceStringData;

    public GeoFenceService(){
        geofenceStringData = new LinkedList<>();
    }


    public Geofences addgeofence(Geofences geofence){
        User newusuario = new User();
        newusuario.setId(1L);
        geofence.setUser(newusuario);
        geofence.setName("Fencee2");
        geofence.setDescription("fence de prueba");
        geofence.setColor("FFFOOO");
        this.geofenceStringData.add(geofence);
        return geofence;
    }

    public void borrarGeoCercas(UUID id){

    }

}