package com.fornax.petware.Entity.AnimalPackage;

public class PetResponse {

    private String name;
    private String specie;
    private String breed;

    public PetResponse() {
    }

    public PetResponse(String name, String specie, String breed) {
        this.name = name;
        this.specie = specie;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
