package com.fornax.petware.Repository.AnimalRepo;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p.name, p.breed, p.date, p.specie  FROM Pet p")
    List<Object[]> findPetData();

    @Query("SELECT p.name, p.breed, p.date, p.specie " +
            "FROM Pet p " +
            "WHERE p.user.id = :userId")
    List<Object[]> findPetDataByUser(@Param("userId") Long userId);

}
