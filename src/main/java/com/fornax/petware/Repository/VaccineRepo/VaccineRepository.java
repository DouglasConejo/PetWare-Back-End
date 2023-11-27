package com.fornax.petware.Repository.VaccineRepo;

import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    @Query("SELECT v.name, v.description FROM Vaccine v WHERE v.vaccine_registry.id = :id_vaccine_register")
    List<String[]> findVaccineregisterById(Long id_vaccine_register);
}
