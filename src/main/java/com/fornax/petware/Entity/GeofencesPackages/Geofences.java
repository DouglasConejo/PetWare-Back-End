package com.fornax.petware.Entity.GeofencesPackages;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "geofences")
public class Geofences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String coordinate;


    //Uno a muchos relacion a sensor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_devince")
    @JsonBackReference
    private Device device_conector;

    //Uno a muchos relacion a Geocerca
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    @JsonBackReference
    private User geofence;

    public Geofences() {
    }

    public Geofences(long ID, String name, String coordinate, User geofence) {
        this.id = ID;
        this.name = name;
        this.coordinate = coordinate;
        this.geofence = geofence;
    }

    public long getId() {
        return id;
    }

    public void setId(long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public User getGeofence() {
        return geofence;
    }

    public void setGeofence(User geofence) {
        this.geofence = geofence;
    }
}
