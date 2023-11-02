package com.fornax.petware.Entity.DevicePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int serialNumber;

    private String ubication;

    private String coordinates;

    @OneToMany(mappedBy = "device_conector",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Geofences> geofences = new ArrayList<>();

    public Device() {
    }

    public Device(long id, int serialNumber, String ubication, String coordinates) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ubication = ubication;
        this.coordinates = coordinates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
