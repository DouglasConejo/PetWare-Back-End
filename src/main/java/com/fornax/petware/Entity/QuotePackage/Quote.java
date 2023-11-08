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

    private String reason;

    @Column(name = "phone_call")
    private String call;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_fk")
    @JsonBackReference
    private User quotes;

    public Quote() {
    }

    public Quote(long id, Date date, String reason, String call, User quotes) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.call = call;
        this.quotes = quotes;
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
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public User getQuotes() {
        return quotes;
    }

    public void setQuotes(User quotes) {
        this.quotes = quotes;
    }
}
