package com.fornax.petware.Entity.QuotePackage;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.AnimalPackage.PetResponse;

public class QuoteDTO {

    private String date;
    private PetResponse pet;
    private String location;
    private String reason;
    private long id_user;

    public QuoteDTO() {
    }

    public QuoteDTO(String date, PetResponse pet, String location, String reason, long id_user) {
        this.date = date;
        this.pet = pet;
        this.location = location;
        this.reason = reason;
        this.id_user = id_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PetResponse getPet() {
        return pet;
    }

    public void setPet(PetResponse pet) {
        this.pet = pet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
}
