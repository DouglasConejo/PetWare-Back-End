package com.fornax.petware.Entity.DiseasePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="disease_registry_fk")
    @JsonBackReference
    private Disease_Registry disease_registry;

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

    public Disease_Registry getDisease_registry() {
        return disease_registry;
    }

    public void setDisease_registry(Disease_Registry disease_registry) {
        this.disease_registry = disease_registry;
    }
}
