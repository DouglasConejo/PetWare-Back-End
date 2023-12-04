package com.fornax.petware.Entity.DiseasePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String description;

    @OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "disease-registry_disease")
    private List<Disease_Registry> disease_registry;

    public Disease() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Disease_Registry> getDisease_registry() {
        return disease_registry;
    }

    public void setDisease_registry(List<Disease_Registry> disease_registry) {
        this.disease_registry = disease_registry;
    }
}
