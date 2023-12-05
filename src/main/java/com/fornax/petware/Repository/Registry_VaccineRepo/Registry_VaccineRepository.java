package com.fornax.petware.Repository.Registry_VaccineRepo;

import com.fornax.petware.Entity.Vaccine_RegistryPackage.VaccineRegistryDTO;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Registry_VaccineRepository extends JpaRepository<Vaccine_Registry, Long> {


    @Query("Select V.id, V.description, V.recovery_date, VS.name as vaccineName from Vaccine_Registry as V JOIN Vaccine VS on V.vaccine.id = VS.id where V.pet.id = :petId")
    List<String[]> findVaccinesByPetId(@Param("petId") Long petId);
}
