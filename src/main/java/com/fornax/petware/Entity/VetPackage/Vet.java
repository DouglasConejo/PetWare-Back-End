package com.fornax.petware.Entity.VetPackage;
import jakarta.persistence.*;


@Entity
@Table(name = "vets")
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String email;

    @Column(name = "phone")
    private String phone;


}
