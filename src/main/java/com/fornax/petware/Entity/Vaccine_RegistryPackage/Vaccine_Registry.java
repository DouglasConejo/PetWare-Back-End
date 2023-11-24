package com.fornax.petware.Entity.Vaccine_RegistryPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.History_VaccinePackage.History_Vaccine;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Table(name = "vaccine_register")
public class Vaccine_Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="historial_vaccine_fk")
    @JsonBackReference(value = "vaccine-registry_vaccine_history")
    private History_Vaccine history_vaccine;

    private String description;

    private Date recovery_date;

    @OneToMany(mappedBy = "vaccine",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "vaccine-registry_vaccine")
    List<Vaccine> vaccine = new ArrayList<>();

    public Vaccine_Registry() {
    }

    public Vaccine_Registry(long id, History_Vaccine history_vaccine, String description, Date recovery_date) {
        this.id = id;
        this.history_vaccine = history_vaccine;
        this.description = description;
        this.recovery_date = recovery_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public History_Vaccine getHistory_vaccine() {
        return history_vaccine;
    }

    public void setHistory_vaccine(History_Vaccine history_vaccine) {
        this.history_vaccine = history_vaccine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRecovery_date() {
        return recovery_date;
    }

    public void setRecovery_date(Date recovery_date) {
        this.recovery_date = recovery_date;
    }
}
