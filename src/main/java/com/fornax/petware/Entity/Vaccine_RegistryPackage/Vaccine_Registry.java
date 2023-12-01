package com.fornax.petware.Entity.Vaccine_RegistryPackage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "vaccine_register")
public class Vaccine_Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_fk")
    @JsonManagedReference(value = "pet-vaccine_registries")
    private Pet petVaccine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vaccine_fk")
    @JsonManagedReference(value = "vaccine-vaccine_registries")
    private Vaccine vaccineRegistry;
    private String description;

    private Date recovery_date;



    public Vaccine_Registry() {
    }

    public Vaccine_Registry(long id, Pet petVaccine, String description, Date recovery_date) {
        this.id = id;
        this.petVaccine = petVaccine;
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
}
