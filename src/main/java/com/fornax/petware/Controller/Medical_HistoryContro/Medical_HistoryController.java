package com.fornax.petware.Controller.Medical_HistoryContro;

import com.fornax.petware.Entity.History_VaccinePackage.History_Vaccine;
import com.fornax.petware.Entity.Medical_HistoryPackage.Medical_History;
import com.fornax.petware.Repository.History_VaccineRepo.History_VaccineRepository;
import com.fornax.petware.Repository.Medical_HistoryRepo.Medical_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Medical_HistoryController {


    @Autowired
    Medical_HistoryRepository medical_historyRepository;

    @PostMapping("medical_history")
    public Medical_History addMedicalVaccine(@RequestBody Medical_History medicalHistory) {
        return medical_historyRepository.save(medicalHistory);
    }
    @DeleteMapping("/medical_history/{id}")
    public ResponseEntity<?> deleteMedicalHistory(@PathVariable(value = "id") Long id) {
        medical_historyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

