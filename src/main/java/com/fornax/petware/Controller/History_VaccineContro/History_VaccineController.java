package com.fornax.petware.Controller.History_VaccineContro;

import com.fornax.petware.Entity.History_VaccinePackage.History_Vaccine;
import com.fornax.petware.Repository.History_VaccineRepo.History_VaccineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class History_VaccineController {

    @Autowired
    History_VaccineRepository vaccine_historyRepository;

    @PostMapping("vaccine_history")
    public History_Vaccine addHistoryVaccine(@RequestBody History_Vaccine vaccineHistory) {
        return vaccine_historyRepository.save(vaccineHistory);
    }
    @DeleteMapping("/vaccine_history/{id}")
    public ResponseEntity<?> deleteVaccineHistory(@PathVariable(value = "id") Long id) {
        vaccine_historyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
