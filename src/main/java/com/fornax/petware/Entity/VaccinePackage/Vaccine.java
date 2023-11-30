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

    @OneToMany(mappedBy = "vaccineRegistry",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "vaccine-vaccine_registries")
    List<Vaccine_Registry> vaccine_registries = new ArrayList<>();
    private String description;

    private String name;

    public Vaccine() {
    }

    public Vaccine(long id, String description, String name) {
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
}
