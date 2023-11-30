package com.fornax.petware.Controller.VaccineContro;

import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Repository.VaccineRepo.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class VaccineController {

    @Autowired
    VaccineRepository vaccineRepository;

    @PostMapping("vaccine_add")
    public Vaccine addVaccineRegistry(@RequestBody Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }
    @DeleteMapping("/vaccine/{id}")
    public ResponseEntity<?> deleteVaccine(@PathVariable(value = "id") Long id) {
        vaccineRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
