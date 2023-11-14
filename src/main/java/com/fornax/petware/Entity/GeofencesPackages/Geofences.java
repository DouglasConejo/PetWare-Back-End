package com.fornax.petware.Entity.GeofencesPackages;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.QuotePackage.Quote;
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

    private String color;

    private String description;


    //Uno a muchos relacion a Geocerca
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    @JsonBackReference(value = "user-geofences")
    private User user;

    @OneToMany(mappedBy = "coordinates",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Coordinate> coordinates = new ArrayList<>();

    public Geofences() {
    }

    public Geofences(long ID, String name, String color, User user, String description) {
        this.id = ID;
        this.name = name;
        this.color = color;
        this.user = user;
        this.description = description;
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


    public User getUser() {
        return user;
    }

    public void setUser(User geofence) {
        this.user = geofence;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
