package com.fornax.petware.Entity.AnimalPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_fk")
    @JsonBackReference
    private User user;

}
