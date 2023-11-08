package com.fornax.petware.Controller.Pet_HistoryContro;

import com.fornax.petware.Entity.Pet_History.PetHistory;
import com.fornax.petware.Repository.Pet_HistoryRepo.Pet_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
