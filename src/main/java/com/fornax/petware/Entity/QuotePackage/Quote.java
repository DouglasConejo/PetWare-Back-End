package com.fornax.petware.Entity.QuotePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @Column(name = "location")
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference("user-quotes")
    private User quotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_fk")
    @JsonBackReference
    private Pet quotePet;

    public Quote() {
    }

    public Quote(long id, Date date, String reason, String location, User quotes,Pet pets) {
        super();
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.location = location;
        this.quotes = quotes;
        this.quotePet=pets;

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

    public String getCall() {
        return location;
    }

    public void setCall(String location) {
        this.location = location;
    }

    public User getQuotes() {
        return quotes;
    }

    public void setQuotes(User quotes) {
        this.quotes = quotes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Pet getQuotePet() {
        return quotePet;
    }

    public void setQuotePet(Pet quotePet) {
        this.quotePet = quotePet;
    }
}
