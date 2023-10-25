package com.fornax.petware.Entity.QuotePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_fk")
    @JsonBackReference
    private User quotes;

}
