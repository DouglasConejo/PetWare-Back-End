package com.fornax.petware.Entity.History_VaccinePackage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "history_vaccine")
public class History_Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Relaciòn de uno a uno hacìa Pet

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToMany(mappedBy = "history_vaccine",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "vaccine-registry_vaccine_history")
    List<Vaccine_Registry> vaccine_registries = new ArrayList<>();

    public History_Vaccine() {

    }

    public History_Vaccine(long id, Pet pet, List<Vaccine_Registry> vaccine_registries) {
        this.id = id;
        this.pet = pet;
        this.vaccine_registries = vaccine_registries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Vaccine_Registry> getVaccine_registries() {
        return vaccine_registries;
    }

    public void setVaccine_registries(List<Vaccine_Registry> vaccine_registries) {
        this.vaccine_registries = vaccine_registries;
    }
}

