package com.fornax.petware.Entity.VaccinePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private String name;

    @OneToMany(mappedBy = "vaccine")
    @JsonManagedReference(value = "vaccine_registry_reference")
    private List<Vaccine_Registry> vaccines;

    public Vaccine() {
    }

    public Vaccine(long id, String description, String name) {
        super();
        this.id = id;
        this.description = description;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vaccine_Registry> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine_Registry> vaccines) {
        this.vaccines = vaccines;
    }
}
