package com.fornax.petware.Controller.Pet_HistoryContro;

import com.fornax.petware.Entity.Pet_History.PetHistory;
import com.fornax.petware.Repository.Pet_HistoryRepo.Pet_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Pet_HistoryController {

    @Autowired
    Pet_HistoryRepository pet_historyRepository;

    @GetMapping("pet_histories")
    public List<PetHistory> getAllPetHistories() {
        return pet_historyRepository.findAll();
    }


    @PostMapping("pet_history")
    public PetHistory addHistoryPet(@RequestBody PetHistory petHistory) {
        return pet_historyRepository.save(petHistory);
    }
    @DeleteMapping("/pet_history/{id}")
    public ResponseEntity<?> deletePetHistory(@PathVariable(value = "id") Long id) {
        pet_historyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pets/{petId}/histories")
    public List<Object[]> getPetHistories(@PathVariable Long petId) {

        return pet_historyRepository.findByPetId(petId);

    }
}
