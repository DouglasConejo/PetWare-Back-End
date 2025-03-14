package com.fornax.petware.Entity.Disease_RegistryPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.Date;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "disease_registry")
public class Disease_Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String treatment;
    @Column(nullable = true)
    private Date recovery_date;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_fk")
    @JsonBackReference(value = "pet-disease_registries")
    private Pet petDisease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diseas_fk")
    @JsonBackReference(value = "disease-registry_disease")
    Disease disease;

    public Disease_Registry() {
    }

    public Disease_Registry(long id, String treatment, Date recovery_date, String description, Pet pet, Disease disease) {
        this.id = id;
        this.treatment = treatment;
        this.recovery_date = recovery_date;
        this.description = description;
        this.petDisease = pet;
        this.disease = disease;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getRecovery_date() {
        return recovery_date;
    }

    public void setRecovery_date(Date recovery_date) {
        this.recovery_date = recovery_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPetDisease() {
        return petDisease;
    }

    public void setPetDisease(Pet petDisease) {
        this.petDisease = petDisease;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease diseases) {
        this.disease = diseases;
    }
}
