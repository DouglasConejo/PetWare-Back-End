package com.fornax.petware.Entity.AnimalPackage;

import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity()
public class AnimalDetailPackage extends Pet {

    private String latitude;

    private String longitude;

    public AnimalDetailPackage() {
        super();
    }

    public AnimalDetailPackage(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AnimalDetailPackage(long id_pet, String name, String specie, String breed, Date date, User user, Device device) {
        super(id_pet, name, specie, breed, date, user, device );
    }

    public AnimalDetailPackage(long id_pet, String name, String specie, String breed, Date date, String latitude, String longitude) {
        super(id_pet, name, specie, breed, date);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AnimalDetailPackage(long id_pet, User user, String name, String specie, String breed, Date date, String latitude, String longitude) {
        super(id_pet, user, name, specie, breed, date);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
