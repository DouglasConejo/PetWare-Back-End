package com.fornax.petware.Entity.CoordinatesPackage;


import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
@Table(name = "coordinate")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float lat;

    private float ing;

    @Column(columnDefinition = "int")
    private int orderNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_geofence")
    @JsonBackReference
    private Geofences coordinates;

    public Coordinate() {
    }

    public Coordinate(long id, float lat, float ing, int orderNum, Geofences geofence) {
        this.id = id;
        this.lat = lat;
        this.ing = ing;
        this.orderNum = orderNum;
        this.coordinates = geofence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getIng() {
        return ing;
    }

    public void setIng(float ing) {
        this.ing = ing;
    }

    public int getOrder() {
        return orderNum;
    }

    public void setOrder(int orderNum) {
        this.orderNum = orderNum;
    }


}
