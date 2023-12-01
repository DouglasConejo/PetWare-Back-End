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


    @GetMapping("/vaccine")
    public List<Vaccine> listVaccines() {
        return vaccineRepository.findAll();
    }

    @GetMapping("/vaccine/{Id}/pets")
    public List<Vaccine> getDisease_RegistryJSON(@PathVariable Long petId) {
        List<String[]> queryResponse = vaccineRepository.findVaccineregisterById(petId);
        ArrayList<Vaccine> vaccines= new ArrayList<>();
        queryResponse.forEach(p -> {
            Vaccine vaccine= new Vaccine();
            vaccine.setId(Long.parseLong(p[0]));
            vaccine.setDescription((p[1]));
            vaccine.setName((p[2]));
            vaccines.add(vaccine);
        });
        return vaccines;
    }
}
