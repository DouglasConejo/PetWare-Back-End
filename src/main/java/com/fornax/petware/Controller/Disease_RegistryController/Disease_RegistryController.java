package com.fornax.petware.Controller.Disease_RegistryController;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Repository.Disease_RegistryRepo.Disease_RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Disease_RegistryController {


    @Autowired
    Disease_RegistryRepository diseaseRegistryRepository;

    @PostMapping("disease_registry_add")
    public Disease_Registry addDiseaseRegistry(@RequestBody Disease_Registry disease_registry) {
        return diseaseRegistryRepository.save(disease_registry);
    }
    @DeleteMapping("/disease_registry/{id}")
    public ResponseEntity<?> deleteDisease(@PathVariable(value = "id") Long id) {
        diseaseRegistryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/disease_registry/{Id}/pets")
    public List<Disease_Registry> getDisease_RegistryJSON(@PathVariable Long petId) {
        List<String[]> queryResponse = diseaseRegistryRepository.findMedical_historyById(petId);
        ArrayList<Disease_Registry> disease_registries = new ArrayList<>();
        queryResponse.forEach(p -> {
            Disease_Registry diseaseRegistry = new Disease_Registry();
            diseaseRegistry.setId(Long.parseLong(p[0]));
            diseaseRegistry.setDescription((p[1]));
            diseaseRegistry.setTreatment((p[2]));
            // Parsear la fecha utilizando SimpleDateFormat
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date recoveryDate = dateFormat.parse(p[4]);
                diseaseRegistry.setRecovery_date(recoveryDate);
            } catch (ParseException e) {
                // Manejar la excepción si hay un problema al parsear la fecha
                e.printStackTrace();
            }
            disease_registries.add(diseaseRegistry);
        });
        return disease_registries;
    }
}

