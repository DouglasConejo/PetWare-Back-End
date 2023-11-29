package com.fornax.petware.Entity.Disease_RegistryPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
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

    private Date recovery_date;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_fk")
    @JsonManagedReference(value = "pet-disease_registries")
    private Pet petDisease;

    @OneToMany(mappedBy = "disease_registry",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "disease-registry_disease")
    List<Disease> diseases = new ArrayList<>();

    public Disease_Registry() {
    }

    public Disease_Registry(long id, String treatment, Date recovery_date, String description, Pet pet, List<Disease> diseases) {
        this.id = id;
        this.treatment = treatment;
        this.recovery_date = recovery_date;
        this.description = description;
        this.petDisease = pet;
        this.diseases = diseases;
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

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
