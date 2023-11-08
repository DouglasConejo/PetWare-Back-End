package com.fornax.petware.Controller.Pet_HistoryContro;

import com.fornax.petware.Entity.Pet_History.PetHistory;
import com.fornax.petware.Repository.Pet_HistoryRepo.Pet_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
