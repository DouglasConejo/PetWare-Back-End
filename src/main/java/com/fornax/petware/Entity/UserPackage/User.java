package com.fornax.petware.Entity.UserPackage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.QuotePackage.Quote;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pet;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private Role role;

    //Uno a muchos
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Pet> pet = new ArrayList<>();


    @OneToMany(mappedBy = "quotes",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Quote> quotes = new ArrayList<>();

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
}
