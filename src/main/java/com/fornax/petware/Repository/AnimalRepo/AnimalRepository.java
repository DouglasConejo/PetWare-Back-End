package com.fornax.petware.Repository.AnimalRepo;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.Disease_RegistryPackage.MonthlySickPetsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

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


    @Query("SELECT ds.name, COUNT(d) as count FROM Disease ds JOIN Disease_Registry d on d.disease.id = ds.id GROUP BY ds.name ORDER BY count DESC")
    List<String[]> findMostCommonDisease(@Param("petList") List<Long> petIds);

    @Query("SELECT MONTH(COALESCE(dr.recovery_date, pet.date)) as month, COUNT(pet.id) as numPets " +
            "FROM Pet pet " +
            "LEFT JOIN pet.disease_registries dr " +
            "WHERE pet.user.id = :userId " +
            "GROUP BY MONTH(COALESCE(dr.recovery_date, pet.date))")
    List<String[]> findSickPetsPerMonthByUser(@Param("userId") Long userId);


    @Query("SELECT MONTH(COALESCE(dr.recovery_date, pet.date)) as month, COUNT(pet.id) as numPets " +
            "FROM Pet pet " +
            "LEFT JOIN pet.disease_registries dr " +
            "WHERE pet.user.id = :userId " +
            "AND pet.isSick = 1 " +
            "GROUP BY MONTH(COALESCE(dr.recovery_date, pet.date))" +
            "ORDER BY MONTH(COALESCE(dr.recovery_date, pet.date)) ASC")
    List<Object[]> findSickPetsPerMonthByUser2(@Param("userId") Long userId);


    @Query("SELECT MONTH(dr.recovery_date) as month, COUNT(dr.id)\n" +
            "FROM Disease_Registry dr\n" +
            "JOIN dr.petDisease p\n" +
            "WHERE p.user.id = :userId\n" +
            "GROUP BY month\n" +
            "ORDER BY MONTH(dr.recovery_date) ASC")
    List<Object[]> findSickPetsPerMonthByUser3(@Param("userId") Long userId);



}
