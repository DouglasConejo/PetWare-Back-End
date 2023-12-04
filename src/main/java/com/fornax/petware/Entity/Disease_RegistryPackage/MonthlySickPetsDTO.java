package com.fornax.petware.Entity.Disease_RegistryPackage;

public class MonthlySickPetsDTO {
    private String month;
    private int numPets;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getNumPets() {
        return numPets;
    }

    public void setNumPets(int numPets) {
        this.numPets = numPets;
    }

    public MonthlySickPetsDTO() {
    }

    public MonthlySickPetsDTO(String month, int numPets) {
        this.month = month;
        this.numPets = numPets;
    }
}
