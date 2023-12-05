package com.fornax.petware.Entity.AnimalPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.Pet_History.PetHistory;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToMany(mappedBy = "pet")
    @JsonManagedReference(value = "pet_vaccine_registry")
    private List<Vaccine_Registry> vaccines;

    private String name;

    private String specie;

    private String breed;

    private Date date;

    //1 = ENFERMO
    //2 = SALUDABLE
    private int isSick;

    public Pet() {
    }

    public Pet(long id, User user, List<PetHistory> petHistories, List<Disease_Registry> disease_registries, Device device, List<Vaccine_Registry> vaccines, String name, String specie, String breed, Date date, int isSick) {
        super();
        this.id = id;
        this.user = user;
        this.petHistories = petHistories;
        this.disease_registries = disease_registries;
        this.device = device;
        this.vaccines = vaccines;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
        this.isSick = isSick;
    }

    public Pet(long idPet, String name, String specie, String breed, Date date, User user, Device device) {
        super();
        this.id = idPet;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
    }

    public Pet(long idPet, String name, String specie, String breed, Date date) {
        super();
        this.id = idPet;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
    }

    public Pet(long idPet, User user, String name, String specie, String breed, Date date) {
        super();
        this.id = idPet;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.date = date;
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

    public List<PetHistory> getPetHistories() {
        return petHistories;
    }

    public void setPetHistories(List<PetHistory> petHistories) {
        this.petHistories = petHistories;
    }

    public List<Disease_Registry> getDisease_registries() {
        return disease_registries;
    }

    public void setDisease_registries(List<Disease_Registry> disease_registries) {
        this.disease_registries = disease_registries;
    }

    public List<Vaccine_Registry> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine_Registry> vaccines) {
        this.vaccines = vaccines;
    }

    public int getIsSick() {
        return isSick;
    }

    public void setIsSick(int isSick) {
        this.isSick = isSick;
    }
}
