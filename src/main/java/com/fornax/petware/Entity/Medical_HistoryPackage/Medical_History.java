package com.fornax.petware.Entity.Medical_HistoryPackage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "medical_history")
public class Medical_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToMany(mappedBy = "medical_history",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "medical_history-registry_disease")
    List<Disease_Registry> disease_registries = new ArrayList<>();
}
