package com.fornax.petware.Repository.Registry_VaccineRepo;

import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Registry_VaccineRepository extends JpaRepository<Vaccine_Registry, Long> {

    @Query("SELECT vr.description, vr.recovery_date, v.name " +
            "FROM Vaccine_Registry vr " +
            "JOIN vr.vaccine v " )
    List<String[]> listPrincipalData();
    @Query("SELECT vr.description, vr.recovery_date, v.name " +
            "FROM Vaccine_Registry vr " +
            "JOIN vr.vaccine v " +
            "JOIN vr.history_vaccine hv " +
            "WHERE hv.pet.id = :petId")
    List<String[]> findDataByIdPet(@Param("petId") Long petId);

    @Query("SELECT vr.description, vr.recovery_date FROM Vaccine_Registry vr WHERE vr.history_vaccine.id = :id_vaccine_history")
    List<String[]> findVaccine_historyById(Long id_vaccine_history);

}
