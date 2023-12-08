package com.fornax.petware.service;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class Disease_RegistryService {

    private List<Disease_Registry> disease_registriesStringData;

    private List<String> disease_registryStringData;


    public Disease_RegistryService(){
        disease_registriesStringData = new LinkedList<>();
    }

    public Disease_Registry addDisease_Registry(Disease_Registry disease_registry) throws ParseException {
        disease_registry.setId(1);
        disease_registry.setDescription("Manchas rojas");
        disease_registry.setTreatment(" ");

        // Crear una instancia de Disease
        Disease disease = new Disease();
        disease.setId(1); // Asignar el ID de la enfermedad
        disease_registry.setDisease(disease);

        // Crear una instancia de Pet
        Pet pet = new Pet();
        pet.setId(1); // Asignar el ID de la mascota
        disease_registry.setPetDisease(pet);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        disease_registry.setRecovery_date(date);

        this.disease_registryStringData.add(String.valueOf(disease_registry));
        return disease_registry;
    }

    public List<String> getPets(){
        return disease_registryStringData;
    }

    public List<Disease_Registry> getAllPetsBackend(){
        return disease_registriesStringData;
    }
}
