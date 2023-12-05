package com.fornax.petware.Entity.Vaccine_RegistryPackage;


import java.util.Date;

public class VaccineRegistryDTO {
    private long id;
    private String description;
    private Date recovery_date;
    private String vaccineName;

    public VaccineRegistryDTO() {
    }

    public VaccineRegistryDTO(long id, String description, Date recovery_date, String vaccineName) {
        this.id = id;
        this.description = description;
        this.recovery_date = recovery_date;
        this.vaccineName = vaccineName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}
