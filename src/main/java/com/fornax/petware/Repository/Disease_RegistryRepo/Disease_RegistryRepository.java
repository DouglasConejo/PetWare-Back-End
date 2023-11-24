package com.fornax.petware.Repository.Disease_RegistryRepo;

import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Disease_RegistryRepository extends JpaRepository<Disease_Registry, Long> {

    @Query("SELECT dr.description, dr.recovery_date,dr.treatment, d.name " +
            "FROM Disease_Registry dr " +
            "JOIN dr.diseases d " +
            "JOIN dr.medical_history mh " +
            "WHERE mh.pet.id = :petId")
    List<String[]> findDataByIdPet(@Param("petId") Long petId);

    @Query("SELECT dr.treatment, dr.description, dr.recovery_date FROM Disease_Registry dr WHERE dr.medical_history.id = :id_medical_history")
    List<String[]> findMedical_historyById(Long id_medical_history);
}
