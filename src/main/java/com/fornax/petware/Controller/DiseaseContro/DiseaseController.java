package com.fornax.petware.Controller.DiseaseContro;

import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Repository.DiseaseRepo.DiseaseRepository;
import com.fornax.petware.Repository.VaccineRepo.VaccineRepository;
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
public class DiseaseController {

    @Autowired
    DiseaseRepository diseaseRepository;

    @PostMapping("disease_add")
    public Disease addDisease(@RequestBody Disease disease) {
        return diseaseRepository.save(disease);
    }
    @DeleteMapping("/disease/{id}")
    public ResponseEntity<?> deleteDisease(@PathVariable(value = "id") Long id) {
        diseaseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/disease/{Id}/pets")
    public List<Disease> getDisease_RegistryJSON(@PathVariable Long petId) {
        List<String[]> queryResponse = diseaseRepository.findDisease_registerById(petId);
        ArrayList<Disease> diseases = new ArrayList<>();
        queryResponse.forEach(p -> {
            Disease disease= new Disease();
            disease.setId(Long.parseLong(p[0]));
            disease.setDescription((p[1]));
            disease.setName((p[2]));
            diseases.add(disease);
        });
        return diseases;
    }
}
