package com.fornax.petware.Repository.DiseaseRepo;

import com.fornax.petware.Entity.DiseasePackage.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    @Query("SELECT d.name, d.description FROM Disease d WHERE d.disease_registry.id = :id_disease_register")
    List<String[]> findDisease_registerById(Long id_disease_register);

}
