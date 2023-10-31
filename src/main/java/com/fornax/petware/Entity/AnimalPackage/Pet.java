package com.fornax.petware.Entity.AnimalPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    @JsonBackReference
    private User user;

}
