package com.fornax.petware.Entity.Vaccine_RegistryPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.Date;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "vaccine_register")
public class Vaccine_Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private Date recovery_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_id")
    @JsonBackReference(value = "vaccine_registry_reference")
    private Vaccine vaccine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    @JsonBackReference(value = "pet_vaccine_registry")
    private Pet pet;


    public Vaccine_Registry() {
    }

    public Vaccine_Registry(long id, String description, Date recovery_date, Vaccine vaccine, Pet pet) {
        super();
        this.id = id;
        this.description = description;
        this.recovery_date = recovery_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRecovery_date() {
        return recovery_date;
    }

    public void setRecovery_date(Date recovery_date) {
        this.recovery_date = recovery_date;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
