package com.fornax.petware.Controller.AnimalContro;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Repository.AnimalRepo.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;


    @GetMapping("pets")
    public List<Pet> getAllPet() {
        return animalRepository.findAll();
    }

    @GetMapping("pets/search")
    public List<Pet> getPetsByName(@RequestParam(value = "name") String name) {
        return animalRepository.searchPetByName(name);
    }

    @GetMapping("/petsData")
    public List<Object[]> getPetData() {
        return animalRepository.findPetData();
    }

    @GetMapping("/user/{userId}/pets")
    public List<Pet> getPets(@PathVariable Long userId) {
        List<Pet> pets = animalRepository.findPetDataByUser(userId);;
        return pets;
    }

    @GetMapping("pets/{id}")
    public
    Optional<Pet> getPet(@PathVariable(value = "id") Long id) {

        Optional<Pet> queryResponse = animalRepository.findById(id);
        return queryResponse;
    }

    @PostMapping("pets")
    public Pet addPet(@RequestBody Pet pet) {
        return animalRepository.save(pet);
    }
    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable(value = "id") Long id) {
        animalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("pet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable(value = "id") Long id,
                                         @RequestBody Pet petUpdate) {

        Optional<Pet> pet = animalRepository.findById(id);

        pet.get().setName(petUpdate.getName());
        pet.get().setSpecie(petUpdate.getSpecie());
        pet.get().setBreed(petUpdate.getBreed());
        pet.get().setDate(petUpdate.getDate());
        Pet updatedPost = animalRepository.save(pet.get());
        return ResponseEntity.ok(updatedPost);
    }

}
