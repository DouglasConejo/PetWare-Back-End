package com.fornax.petware.Controller.AnimalContro;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Repository.AnimalRepo.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;


    @GetMapping("pets")
    public List<Pet> getAllPet() {
        return animalRepository.findAll();
    }

    @GetMapping("pets/{id}")
    public Optional<Pet> getPet(@PathVariable(value = "id") Long id) {
        return animalRepository.findById(id);
    }

    @PostMapping("pets")
    public Pet addPet(@RequestBody Pet pet) {
        return animalRepository.save(pet);
    }
}
