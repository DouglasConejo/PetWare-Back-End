package com.fornax.petware.Entity.AnimalPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.Pet_History.PetHistory;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    @JsonBackReference(value = "user-pets")
    private User user;


    @OneToMany(mappedBy = "petHistory",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pet-petHistory")
    List<PetHistory> petHistories = new ArrayList<>();

    @OneToMany(mappedBy = "petDisease",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pet-disease_registries")
    List<Disease_Registry> disease_registries = new ArrayList<>();

    @OneToMany(mappedBy = "petVaccine",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pet-vaccine_registries")
    List<Vaccine_Registry> vaccine_registries = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToMany(mappedBy = "petQuotes",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pet-quotes")
    List<Quote> pet_Quotes = new ArrayList<>();

    private String name;

    private String specie;

    private String breed;

    private Date date;

    // 0= ENFERMO
    //1 = SALUDABLE
    private int isSick;

    public Pet() {
    }


    public Pet(long id_pet, String name, String specie, String breed, Date date) {
        this.id = id_pet;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
    }

    public Pet(long id, User user, List<PetHistory> petHistories, List<Disease_Registry> disease_registries, Device device, String name, String specie, String breed, Date date, int isSick) {
        this.id = id;
        this.user = user;
        this.petHistories = petHistories;
        this.disease_registries = disease_registries;
        this.device = device;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
        this.isSick = isSick;
    }

    public Pet(long id_pet, String name, String specie, String breed, Date date, User user, Device device) {
        this.id = id_pet;
        this.user = user;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
        this.device = device;
    }

    public Pet(long idPet, User user, String name, String specie, String breed, Date date) {

        this.id = idPet;
        this.user = user;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public void setId(long id_pet) {
        this.id = id_pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int isSick() {
        return isSick;
    }

    public void setSick(int sick) {
        isSick = sick;
    }


}
