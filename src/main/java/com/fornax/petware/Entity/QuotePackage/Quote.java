package com.fornax.petware.Entity.QuotePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private Date date;
    @Column(name = "reason")
    private String reason;

    @Column(name = "ubication")
    private String ubication;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference("user-quotes")
    private User quotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pet")
    @JsonBackReference("pet-quotes")
    private Pet petQuotes;

    public Quote() {
    }

    public Quote(long id, Date date, String reason, String ubication, User quotes,Pet pet) {
        super();
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.ubication = ubication;
        this.quotes = quotes;
        this.petQuotes=pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public User getQuotes() {
        return quotes;
    }

    public void setQuotes(User quotes) {
        this.quotes = quotes;
    }
}
