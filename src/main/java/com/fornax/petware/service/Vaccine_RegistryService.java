package com.fornax.petware.service;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service

public class Vaccine_RegistryService {

    private List<Vaccine_Registry> vaccine_registriesStringData;

    private List<String> vaccine_registryStringData;


    public Vaccine_RegistryService(){
        vaccine_registriesStringData = new LinkedList<>();
    }

    public Vaccine_Registry addRegistry_Vaccine(Vaccine_Registry vaccine_registry) throws ParseException {
        vaccine_registry.setId(1);
        vaccine_registry.setDescription("Contra el covid");

        // Crear una instancia de Disease
        Vaccine vaccine = new Vaccine();
        vaccine.setId(1); // Asignar el ID de la vacuna
        vaccine_registry.setVaccine(vaccine);

        // Crear una instancia de Pet
        Pet pet = new Pet();
        pet.setId(1); // Asignar el ID de la mascota
        vaccine_registry.setPet(pet);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        vaccine_registry.setRecovery_date(date);

        this.vaccine_registryStringData.add(String.valueOf(vaccine_registry));
        return vaccine_registry;
    }

    public List<String> getPets(){
        return vaccine_registryStringData;
    }

    public List<Vaccine_Registry> getAllPetsBackend(){
        return vaccine_registriesStringData;
    }
}
