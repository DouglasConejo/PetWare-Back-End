package com.fornax.petware.service;

import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

@Service

public class VaccineService {
    private List<Vaccine> vaccineStringData;

    private List<String> vaccinesStringData;


    public VaccineService(){
        vaccineStringData = new LinkedList<>();
    }

    public Vaccine addRegistry_Vaccine(Vaccine vaccine) throws ParseException {
        vaccine.setId(1);
        vaccine.setDescription("Contra el covid");
        vaccine.setName("Astra");


        // Crear una instancia de Disease
        Vaccine_Registry vaccine_registry = new Vaccine_Registry();
        vaccine.setId(1);
        vaccine.setVaccines(vaccine_registry.getVaccine().getVaccines());

        this.vaccinesStringData.add(String.valueOf(vaccine));
        return vaccine;
    }

    public List<String> getPets(){
        return vaccinesStringData;
    }

    public List<Vaccine> getAllPetsBackend(){
        return vaccineStringData;
    }
}
