package com.fornax.petware.Entity.Disease_RegistryPackage;

import java.util.Date;

public class DiseaseRegistryDTO {
    private  long id;
    private String treatment;
    private String description;

    private Date recoveryDate;
    private String diseaseName;

    public DiseaseRegistryDTO() {
    }

    public DiseaseRegistryDTO(long id, String treatment, String description, String diseaseName, Date date) {
        this.id = id;
        this.treatment = treatment;
        this.description = description;
        this.diseaseName = diseaseName;
        this.recoveryDate = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Date getRecoveryDate() {
        return recoveryDate;
    }

    public void setRecoveryDate(Date recoveryDate) {
        this.recoveryDate = recoveryDate;
    }
}
