package com.fornax.petware.Repository.AnimalRepo;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p.name, p.breed, p.date, p.specie  FROM Pet p")
    List<Object[]> findPetData();

    @Query("SELECT P FROM Pet P WHERE P.user.id = ?1")
    List<Pet> findPetDataByUser(@Param("userId") Long userId);

    @Query("Select P from Pet P where P.name like :animalName")
    List<Pet> searchPetByName(@Param("animalName") String animalName);

    @Query("SELECT p.user.id, COUNT(p) FROM Pet p WHERE p.user.id = :userId GROUP BY p.user.id")
    List<Object[]> countPetsByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(p) FROM Pet as p where p.isSick = 1 AND p.user.id = :userId")
    Long countSickPets(@Param("userId") Long userId);

    @Query("SELECT COUNT(dr) FROM Pet p " +
            "JOIN p.disease_registries dr " +
            "WHERE p.user.id = :userId")
    Long getTotalDiseasesByUserAndYear(@Param("userId") Long userId);


    @Query("SELECT ds.name, COUNT(d) as count FROM Disease ds LEFT JOIN Disease_Registry d on d.disease.id = ds.id where d.petDisease.id in :petList GROUP BY ds.name ORDER BY count DESC")
    List<Object[]> findMostCommonDisease(@Param("petList") List<Long> petIds);
}
