package com.fornax.petware.Repository.AnimalRepo;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Pet, Long> {


}
