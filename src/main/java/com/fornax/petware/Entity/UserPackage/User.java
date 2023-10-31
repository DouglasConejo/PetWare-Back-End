package com.fornax.petware.Entity.UserPackage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.QuotePackage.Quote;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    //Uno a muchos
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Pet> pet = new ArrayList<>();


    @OneToMany(mappedBy = "quotes",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Quote> quotes = new ArrayList<>();

    @OneToMany(mappedBy = "geofence",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Geofences> geofences = new ArrayList<>();

    public User() {
    }

    public User(String name, String password, String email, String phone, Role role) {
        super();
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Geofences> getGeofences() {
        return geofences;
    }

    public void setGeofences(List<Geofences> geofences) {
        this.geofences = geofences;
    }
}
