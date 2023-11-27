package com.fornax.petware.Controller.Vaccine_Registry_Contro;

import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.Medical_HistoryPackage.Medical_History;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import com.fornax.petware.Repository.Medical_HistoryRepo.Medical_HistoryRepository;
import com.fornax.petware.Repository.Registry_VaccineRepo.Registry_VaccineRepository;
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
public class Vaccine_RegistryController {

    @Autowired
    Registry_VaccineRepository vaccine_registryRepository;

    @PostMapping("vaccine_registry_add")
    public Vaccine_Registry addVaccineRegistry(@RequestBody Vaccine_Registry vaccineRegistry) {
        return vaccine_registryRepository.save(vaccineRegistry);
    }
    @DeleteMapping("/vaccine_registry/{id}")
    public ResponseEntity<?> deleteVaccineRegistry(@PathVariable(value = "id") Long id) {
        vaccine_registryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/vaccines_registry/{Id}/pets")
    public List<Vaccine_Registry> getDisease_RegistryJSON(@PathVariable Long id_vaccine_history) {
        return vaccine_registryRepository.findVaccine_historyById(id_vaccine_history);
//        return disease_registries;
    }
}
