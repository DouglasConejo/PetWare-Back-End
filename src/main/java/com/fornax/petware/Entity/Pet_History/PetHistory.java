package com.fornax.petware.Entity.Pet_History;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "petHistory")
public class PetHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pet")
    @JsonBackReference(value = "pet-petHistory")

    private Pet petHistory;

    private String weight;

    private String height;

    private Date date;

    private String temperature;

    public PetHistory() {
    }

    public PetHistory(long ID, Pet petHistory, String weight, String height, Date date, String temperature) {
        this.id = ID;
        this.petHistory = petHistory;
        this.weight = weight;
        this.height = height;
        this.date = date;
        this.temperature = temperature;
    }

    public long getId() {
        return id;
    }

    public void setId(long ID) {
        this.id = ID;
    }

    public Pet getPetHistory() {
        return petHistory;
    }

    public void setPetHistory(Pet petHistory) {
        this.petHistory = petHistory;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
