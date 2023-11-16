package com.fornax.petware.service;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class PetService {

    private List<Pet> petStringData;

    private List<String> petsStringData;

    public PetService()  {
        petsStringData = new LinkedList<>();
    }
    public Pet addPet(Pet pet) throws ParseException {
        pet.setId(7);
        pet.setName("Marco");
        pet.setSpecie("Toro");
        pet.setBreed("Español");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        pet.setDate(date);
        this.petsStringData.add(String.valueOf(pet));
        return pet;
    }

    public List<String> getPets(){
        return petsStringData;
    }

    public List<Pet> getAllPetsBackend(){
        return petStringData;
    }

}
