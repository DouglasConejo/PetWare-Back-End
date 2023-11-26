package com.fornax.petware.Entity.DevicePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.net.URL;


import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int serialNumber;

    private String ubication;


    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Device() {
    }

    public Device(long id, int serialNumber, String ubication ) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ubication = ubication;
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





}
