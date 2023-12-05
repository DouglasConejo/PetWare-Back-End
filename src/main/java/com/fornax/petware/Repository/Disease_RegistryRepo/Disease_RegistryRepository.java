package com.fornax.petware.Repository.Disease_RegistryRepo;

import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface Disease_RegistryRepository extends JpaRepository<Disease_Registry, Long> {
    @Query("SELECT D.id, D.description, D.treatment, D.recovery_date, ds.name FROM Disease_Registry D JOIN Disease ds ON ds.id = D.disease.id WHERE D.petDisease.id = :petId")
    List<String[]> findDiseasesRegistryById(@Param(value = "petId") Long petId);
}
