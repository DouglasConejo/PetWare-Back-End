package com.fornax.petware.Entity.VaccinePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import jakarta.persistence.*;

@Entity
@Table(name = "vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vaccine_registry_fk")
    @JsonBackReference
    private Vaccine_Registry vaccine_registry;

    private String description;

    private String name;

    public Vaccine() {
    }

    public Vaccine(long id, Vaccine_Registry vaccine_registry1, String description, String name) {
        this.id = id;
        this.vaccine_registry = vaccine_registry1;
        this.description = description;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vaccine_Registry getVaccine_registry() {
        return vaccine_registry;
    }

    public void setVaccine_registry(Vaccine_Registry vaccine_registry) {
        this.vaccine_registry = vaccine_registry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
